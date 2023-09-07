const foundCanvas = (function () {

    //js入口，监听屏幕
    function _prepareCanvas(rects,id,drawConfig) {
        //删除已有画框
        _delCanvas(id);
        //判断是否设置了画框参数
        const config = _isConfig(drawConfig);
        //创建画布
        _createCanvas(rects,id,config);


        window.addEventListener("resize",function () {
            window.addEventListener('load',function () {
                _delCanvas(id);
                _createCanvas(rects,id,config);
            });
        });
    };


    //删除现有画布
    function _delCanvas(id) {

        //判断容器标签是否存在
        if (!document.getElementById(id)){
            alert(`标签${id}不存在`);
            return;
        }
        const box = document.getElementById(id);
        //删除画布
        const canvasCount = box.getElementsByTagName("canvas");
        if (canvasCount.length > 0){
            for (let i=0;i<canvasCount.length;i++){
                document.getElementById("canvas"+id).remove();
            }
        }
    };


    //检查是否配置了画框参数
    function _isConfig(drawConfig) {
        let config = {};
        if (config && drawConfig != "" && drawConfig != null && JSON.stringify(drawConfig) != '{}'){
            config = Object.assign({},drawConfig);
        }else{
            config = {
                lineWidth: 2,
                lineColor: "red"
            }
        }
        return config;
    }

    // 创建画布
    function _createCanvas(rects,id,config) {
        if (!document.getElementById(id)){
            alert(`标签${id}不存在`);
            return;
        }
        const box = document.getElementById(id);
        const divSize = {
            //画布的宽高，等于div的宽高
            w: box.offsetWidth,
            h: box.offsetHeight
        }
        console.log("divSize:"+divSize.w+","+divSize.h);
        const canvasElement = document.createElement("canvas");
        let canvasElementId = "canvas"+id;
        canvasElement.id = canvasElementId;
        console.log("canvasElementId:"+canvasElementId);
        box.appendChild(canvasElement);
        _initCanvas(divSize,rects,canvasElementId,config)

    };

    //初始化，显示画布
    function _initCanvas(divSize,rects,canvasElementId,config) {
        const canvasEle = document.getElementById(canvasElementId);
        const context = canvasEle.getContext("2d");
        const img = document.getElementById("img1");
        const image = new Image();
        image.src = img.src;

        console.log("img.src:"+img.src);
        image.onload = function () {
            document.getElementById(canvasElementId).width = divSize.w;
            document.getElementById(canvasElementId).height = divSize.h;
            context.drawImage(image,0,0,divSize.w,divSize.h);
            _drawRects(context,rects,config);
        }
        img.remove();
    }

    function _drawRects(context,rects,config) {

        if (rects.length === 0){
            return;
        }

        //根据画框的坐标和宽高画框
        for (let i = 0; i < rects.length; i++){
            context.beginPath();
            context.lineWidth = config.lineWidth;
            context.strokeStyle = config.lineColor;
            context.strokeRect(rects[i].x,rects[i].y,rects[i].w,rects[i].h);
        }
    }

    return{
        prepareCanvas:_prepareCanvas
    };
})();