

function shiyan() {
    JsBridge.call('bridgeImpl','fromJsFunction_init','{"name":"zhangsan"}',function (res) {
        console.log("res:"+res);
    });
}

