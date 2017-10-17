var fs = require('fs');
var path = require('path');

var dir = process.argv[2];
var ext = process.argv[3];

fs.readdir(dir, function callback (err, data) { 
if (err) throw err;
var len = data.length;
for(i =0; i < len; i++) {
var ff = data[i];
var ex = path.extname(ff);
if (ex == "."+ext) {
console.log(ff);
}
}
//console.log(data);
/* ... */ 

} );

/*

 var fs = require('fs')
    var path = require('path')
    
    var folder = process.argv[2]
    var ext = '.' + process.argv[3]
    
    fs.readdir(folder, function (err, files) {
      if (err) return console.error(err)
      files.forEach(function (file) {
        if (path.extname(file) === ext) {
          console.log(file)
        }
      })
    })


*/
