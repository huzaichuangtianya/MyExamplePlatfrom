(function (win) {
    var hasOwnProperty = Object.prototype.hasOwnProperty;
    var JsBridge = win.JsBridge || (win.JsBridge = {});
    var JSBRIDGE_PROTOCOL = 'JSBridge';
    var callb = {};
    var port = Util.getPort();
    var innner = {

        call: function (obj, method, param, callback) {
            callb[port] = callback;
            var uri=Util.getUri(obj, method, param, callback);
            window.prompt(uri,'');
        }
        ,
        finish: function (port,jsonp) {
            var cb=callb[port];
               cb&&cb(jsonp);
        }
    };


    var Util = {
        getPort: function () {
            return Math.floor(Math.random() * (1 << 30));
        },

        getUri: function (obj, method, params, port) {
            params = this.getParam(params);
            var uri = JSBRIDGE_PROTOCOL + '://' + obj + ':' + port + '/' + method + '?' + params;
            return uri;
        },
        getParam: function (param) {
            if (param && typeof param === 'object') {
                return JSON.stringify(param);
            }
            return param || '';
        }
    }

})(window);