function callJs() {
    console.log("callJs");
    alert("Android调用了JS的callJS方法");
}


function callJsValue() {
    console.log("callJsValue");
    alert("callJsValue");
    return "nihaoma";
}


function callAndroid() {
    // 由于对象映射，所以调用test对象等于调用Android映射的对象
    test.hello("js调用了android中的hello方法");
}

function callAndroid1() {
    // 由于对象映射，所以调用test对象等于调用Android映射的对象
    document.location = "js://webview?arg1=111&arg2=222";
}

function callAndroid2() {
    // 由于对象映射，所以调用test对象等于调用Android映射的对象
    var result = prompt("js://demo?arg1=845646&arg2=SDKFJKSDLJF");
    console.log("result:" + result);
}

var shiyan={
back1:function () {
    console.log("shiyan1:");
},
//     back1:function (aa) {
//         console.log("shiyan1aa:"+aa);
//     }

};

function shiyan1() {
    console.log("shiyan1:");
}


function shiyan1(aa) {
    console.log("shiyan1aa:"+aa);
}
