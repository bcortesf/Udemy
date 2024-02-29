const { get_uuidv4_PLGN } = require('../plugins/get-id.plugin');
const { getAge_PLGN }     = require('../plugins/get-age.plugin');
const { httpClientPlugin }    = require('../plugins/http-client.plugin');


module.exports = {
    get_uuidv4_PLGN,
    getAge_PLGN,
    httpClientPlugin
};