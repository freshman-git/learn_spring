const fs = require("fs");

//调用方法读取文件
// fs.readFile('../json01.json',(err,data)=>{
//     if (err){
//         throw err;
//     }
//     console.log(data.toString());
// });

//使用promise封装
const p = new Promise(function (resolve,reject) {
    fs.readFile("../json01.json",(err,data)=>{
        if (err){
            reject(err);
        }else {
            resolve(data);
        }
    });
});

// p.then(function (value) {
//     console.log(value.toString());
// },function (reason) {
//     console.log("fail");
// });
p.then(function (value) {
    console.log(value.toString());
}).catch(function (reason) {
    console.log("fail");
})