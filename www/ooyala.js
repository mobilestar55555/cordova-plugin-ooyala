cordova.define("cordova-plugin-ooyala.ooyala", function(require, exports, module) {

    var exec = require('cordova/exec');
    var channel = require('cordova/channel');

    module.exports = {

        createPlayer: function (code, ecode, url, title, success, error) {
            exec(success, error, "Ooyala", "createPlayer", [code, ecode, url, title]);
        },
        initPlayer: function (success, error) {
            exec(success, error, "Ooyala", "initPlayer", []);
        },
    };

});
