const { get_uuidv4_PLGN } = require('../plugins/get-id.plugin');
const { getAge_PLGN }     = require('../plugins/get-age.plugin');
const { http }            = require('../plugins/http-client.plugin');
const buildLogger = require('../plugins/logger.pluggin');



module.exports = {
    get_uuidv4_PLGN,
    getAge_PLGN,
    http,
    buildLogger
};