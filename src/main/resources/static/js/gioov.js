/**
 * jQuery Gioov Utils
 */


var gioov = gioov || {};

(function (_gioov) {

    _gioov ={
        response:{},
        request:{},
        string:{},
        object:{},
        json:{},
        document:{}
    };

    {
        _gioov.json.toObject = function (json) {
            return eval('(' + json + ')');
        };

        _gioov.response.MESSAGE = 'message';
        _gioov.response.CODE = 'code';
        _gioov.response.DATA = 'data';
        _gioov.response.EXCEPTION = 'exception';
        _gioov.response._httpStatus = function (code, message) {
            var json = '{"' + _gioov.response.CODE + '":' + code + ',"' + _gioov.response.MESSAGE + '":"' + message + '"}';
            return _gioov.json.toObject(json);
        };

        _gioov.response.httpStatus = {
            OK: _gioov.response._httpStatus(200, 'OK'),
            NOT_FOUND: _gioov.response._httpStatus(404, 'NOT FOUND')
        };

        _gioov.response.ok = function (responseResult, fnOkCallback, fnNotOkCallback, fnThenCallback) {
            if (responseResult) {

                var OK = _gioov.response.httpStatus.OK.code;

                var data = responseResult.hasOwnProperty(_gioov.response.DATA) ? responseResult[_gioov.response.DATA] : undefined;

                var message = responseResult.hasOwnProperty(_gioov.response.MESSAGE) ? responseResult[_gioov.response.MESSAGE] : undefined;

                var code = responseResult.hasOwnProperty(_gioov.response.CODE) ? responseResult[_gioov.response.CODE] : undefined ;

                if (code === OK) {
                    if (typeof fnOkCallback === 'function') {
                        fnOkCallback(data, message, code);
                    }
                } else {
                    if (typeof fnNotOkCallback === 'function') {
                        fnNotOkCallback(data, message, code);
                    }
                }

                if (typeof fnThenCallback === 'function') {
                    fnThenCallback(data, message, code);
                }

            }
        };

        _gioov.request.getQueryParam = function (name){
            var href = window.location.href;
            var arr = href.split('?');
            if(arr){
                if(arr.length > 1){
                    var arr1 = arr.splice(1);
                    var arr2 = arr1[0];
                    var arr3 = arr2.split('&');
                    if(arr3){
                        if(arr3.length >= 1){
                            for(var i =0; arr3.length>i; i++){
                                var arr4 = arr3[i];

                                if(arr4){
                                    var arr5 = arr4.split('=');
                                    if(arr5){
                                        if(arr5.length>=2){
                                            if(name === arr5[0]){
                                                return arr5[1];
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }


                }
            }

        };

        _gioov.ajax = function (options) {
            if(!window.jQuery){
                alert('gioov.ajax 需要jQuery支持');
                return;
            }
            var defaults = {
                async: true,
                type: 'get',
                dataType: 'json',
                processData: true,
                error: function (xhr, textStatus, errorThrown) {
                    console.log(xhr);
                }
            };

            $.extend(defaults, options);
            return $.ajax(defaults);
        };

        _gioov.string.replaceAllPlaceholder = function (string,searchValue,replaceValue) {
            return string.replace(new RegExp('{' + searchValue + '}', "gm"),replaceValue);
        };

        // 获取字符的长度
        _gioov.string.countSymbols = function(string) {
            var regexAstralSymbols = /[\uD800-\uDBFF][\uDC00-\uDFFF]/g;
            return string
            // 把代理对改为一个BMP的字符.
                .replace(regexAstralSymbols, '_')
                // …这时候取长度就妥妥的啦.
                .length;
        };

        // 获取前6个字符
        _gioov.string.sliceSymbols = function (str, limit) {
            var regexAstralSymbols = /[\uD800-\uDBFF][\uDC00-\uDFFF]/g;
            var output = [];
            var index = 0;
            var oldStr = str;
            str = str.replace(regexAstralSymbols, function(input, offset, match) {
                if( offset > index ) {
                    output = output.concat(match.slice(index, offset).split(""));
                }
                index = offset + input.length;
                output.push(input);
                return "";
            });

            if( index < oldStr.length  ) {
                output = output.concat(oldStr.slice(index, oldStr.length).split(""));
            }
            return output.slice(0, limit).join("");
        };

        _gioov.document.create = function (options,tag) {
            var _body = document.body;
            var _tag;
            if(tag) {
                _tag = document.createElement(tag);
            }else{
                _tag = document.createElement('div');
            }
            if(typeof options === 'string'){
                var selector = options.charAt(0);
                if(selector){
                    switch (selector){
                        case '#':
                            options = options.substring(1,options.length);
                            _tag.id = options;
                            break;
                        case '.':
                            options = options.substring(1,options.length);
                            _tag.className = options;
                            break;
                        default:
                            break;
                    }
                }
                return _body.appendChild(_tag);
            }
        };

        _gioov.formatter = function (key, defaultValue, keyValue, formatterCallback) {
            var result;
            if(typeof keyValue === 'object'){
                for(var k in keyValue) {
                    switch (typeof key){
                        case 'number':
                            k = parseInt(k);
                            break;
                        case 'string':
                            k = k.toString();
                            break;
                    }
                    if (key === k) {
                        result = keyValue[k];
                        break;
                    }
                }
                if(typeof result === 'undefined'){
                    if(typeof defaultValue !== 'undefined'){
                        result = defaultValue;
                    }
                }
            }


            if(typeof formatterCallback === 'function'){
                result = formatterCallback(result, key, defaultValue, keyValue);
            }

            return result;
        };
    }

    gioov = _gioov;
})(gioov);


//
// <div id="pageloading" style="display: none;"></div>
//
// #pageloading
// {
//     position: absolute;
//     left: 0
//     px;
//     top: 0
//     px;
//     background: white
//     url(loading.gif)
//     no - repeat
//     center;
//     width: 100 %;
//     height: 100 %;
//     z - index
// :
//     99999;
// }