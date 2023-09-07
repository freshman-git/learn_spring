const foundCanvas = (function(){

    let localBox = [];

    // 创建画布
    function _createCanvas(boxList, id, config){
        // 判断标签容器是否存在
        if(!document.getElementById(id)) {
            console.log(`标签id:${id},不存在`);
            return
        }
        const div = document.getElementById(id);
        const list = JSON.parse(JSON.stringify(boxList));
        console.log("list:"+list[0].src);
        const divSize = {
            w: div.offsetWidth/list.length, // 返回元素的总宽度
            h: div.offsetHeight/(list.length)// 返回元素的总高度
        }
        console.log("divSize:"+divSize.w+","+divSize.h);
        // 创建canvas标签
        for(let i=0;i<list.length;i++){
            const canvas = document.createElement('canvas');
            let canvasId = "canvas" + i+"_"+id;
            canvas.id= canvasId;
            // console.log("canvas.id:"+canvas.id)
            div.appendChild(canvas);
            const img = document.getElementById(canvasId);
            img.style.padding = "1px 1px";
            _initCanvas(divSize,list[i],canvasId,config);
        }
    };

    // 初始化 显示画布
    function _initCanvas(divSize, localBox, id, config){
        const pointArray = [];
        const history = [];
        let mousedown = null;
        let dragging = false;

        //把localBox属性给一个空对象
        let boxList =  Object.assign({}, localBox);
        const conv=document.getElementById(id);

        //contextType参数有以下四种：
        //
        // "2d"：创建一个CanvasRenderingContext2D对象作为2D渲染的上下文。
        // "webgl"(或"experimental-webgl")：创建一个WebGLRenderingContext对象作为3D渲染的上下文，只在实现了WebGL 2的浏览器上可用，实验性特性。
        // "webgl2"：创建一个WebGL2RenderingContext对象作为3D渲染的上下文，只在实现了WebGL 3的浏览器上可用。
        // "bitmaprenderer"：创建一个ImageBitmapRenderingContext，用于将位图渲染到canvas上下文上，实验性特性。
        const ctx=conv.getContext("2d");
        let imgwidth;                       // 图片宽度
        let imgheight;                      // 图片高度
        let imgObj = new Image();           // 创建image对象
        imgObj.src = boxList.src;
        imgObj.onload = function(){
            // 设置画布大小
            imgwidth = imgObj.width;
            imgheight = imgObj.height;
            document.getElementById(id).width = divSize.w;
            document.getElementById(id).height = divSize.h;


            //1、image：image是画布绘制的图像源，绘制到画布上的元素，可以是canvasElement,imageElement,svgImageElement ,videoElement等一系列具有图像的元素。
            // 2、sx：绘制裁剪的图像源的x 坐标位置；
            // 3、sy：绘制裁剪的图像源的y坐标位置；
            // 4、sWidth：绘制裁剪的图像源的宽度；
            // 5、sHeight：绘制裁剪的图像源的高度；
            // 6、dx：目标源在canvas画布上绘制的左上角的x坐标；
            // 7、dy：目标源在canvas画布上绘制的左上角的y坐标；
            // 8、dWidth：目标源在canvas画布上绘制的宽度，会自动根据图像源截取的宽度对比做缩放；
            // 9、dWidth：目标源在canvas画布上绘制的高度，会自动根据图像源截取的高度对比做缩放；
            // this即是imgObj
            ctx.drawImage(this, 0, 0, divSize.w, divSize.h);
            boxList = _calculateSize(divSize, boxList, imgwidth, imgheight);

            _drawOldRecs(boxList.rects, config);
        };
        // 计算比例尺寸显示适配
        function _calculateSize(divSize, boxList, imgwidth, imgheight){
            let widthImgCanvasPercentage;       // 宽度比例
            let heightImgCanvasPercentage;      // 高度比例
            let subWidth = divSize.w / imgwidth;// 算出显示比例
            let subHeight = divSize.h / imgheight
            widthImgCanvasPercentage = subWidth.toString();
            heightImgCanvasPercentage = subHeight.toString();

            boxList.rects.forEach(function (element) { // 计算显示尺寸并适配显示
                element.x = Math.round(element.x * widthImgCanvasPercentage);
                element.y = Math.round(element.y * heightImgCanvasPercentage);
                element.w = Math.round(element.w * widthImgCanvasPercentage);
                element.h = Math.round(element.h * heightImgCanvasPercentage);
            });
            return boxList;
        };
        // 画框
        function _drawOldRecs(rects, config) {
            if (rects.length == 0) {
                return;
            }

            for (let i = 0; i < rects.length; i++) {
                ctx.beginPath();
                ctx.lineWidth = config.lineWidth;
                ctx.strokeStyle = config.strokeStyle;
                ctx.strokeRect(rects[i].x, rects[i].y, rects[i].w, rects[i].h);
                // ctx.fillText("异物01", rects[i].x, rects[i].y);    // 画框上加文字
            }
        };
    };
    // js入口，监听屏幕
    function _prepareCanvas(boxList, id, config){
        localBox =  JSON.parse(JSON.stringify(boxList));
        _delCanvas(boxList, id);
        const conf = _isConfig(config);
        _createCanvas(boxList, id, conf);
        // 执行一次
        window.addEventListener('load', function() {
            // 窗口改变执行
            window.addEventListener('resize', function() {
                localBox =  JSON.parse(JSON.stringify(boxList));
                _delCanvas(boxList, id);
                // 重新创建画布
                _createCanvas(localBox, id, conf);
            })

        })
    };
    // 判断是否配置
    function _isConfig(config){
        let conf = {};
        // 配置判断
        if(config && config != ""){
            conf = Object.assign({}, config);
        }else{
            conf = {
                lineWidth:2,                    // 画框线粗细
                strokeStyle:"red" // 画框线颜色
            }
        }
        return conf;
    };
    // 删除画布canvas标签
    function _delCanvas(boxList,id){
        localBox =  JSON.parse(JSON.stringify(boxList));
        // 判断标签容器是否存在
        if(!document.getElementById(id)) {
            console.log(`标签id:${id},不存在`);
            return;
        }
        // 删除画布
        const div = document.getElementById(id);
        const canvasCount = div.getElementsByTagName("canvas");

        if(canvasCount.length>0){
            for(let i=0; i<localBox.length; i++){
                document.getElementById("canvas"+i+"_"+id).remove();
            }
        }
    };

    return {
        prepareCanvas:_prepareCanvas
    };
})();

// export default foundCanvas;