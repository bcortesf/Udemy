const winston = require('winston');

const { combine, timestamp, json } = winston.format;

const logger = winston.createLogger({
    level: 'info',

    // format: winston.format.json(),
    /**---------------------------- */
    // format: winston.format.combine(
    //     winston.format.timestamp(),
    //     winston.format.simple(),
    // ),
    /**---------------------------- */
    // format: winston.format.combine(
    //     winston.format.timestamp(),
    //     winston.format.prettyPrint()
    // ),
    /**---------------------------- */
    /**--------Destructuring------- */
    format: combine(
        timestamp(),
        json()
    ),


    transports: [
        //
        // - Write all logs with importance level of `error` or less to `error.log`
        // - Write all logs with importance level of `info` or less to `combined.log`
        //
        new winston.transports.File({ filename: 'error.log', level: 'error' }),
        new winston.transports.File({ filename: 'combined.log' }),
    ],
});


/**
 * https://www.npmjs.com/package/winston
 * @param {*} service : En cualk esta ocurriendo el problema:
 *     - cual (servicio, archivo, modulo, clase) sucede el problema
 * @returns
 */
module.exports = function buildLogger(service) {
    return  {
        // log: (message) => {
        //     logger.log({
        //         level: 'info',
        //         message: message,
        //         label: service
        //     });
        // },
        log: (message) => {
            logger.log('info', {
                message,
                service,
                // at: new Date().toISOString()
            });
        },
        error: (message) => {
            logger.error('error ', {message, service});
        },
    }
}


/**
    logger.info('INFO');
    logger.error('ERROR');
    logger.warn('WARN');
    logger.debug('DEBUG');
    logger.verbose('VERBOSE');
    logger.silly('SILLY');
 */