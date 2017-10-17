var fs = require('fs');
var file_path = process.argv[2];
fs.readFile(file_path, function callback (err, data) {
if(err) {return console.log(err)}
// fs.readFile(file, 'utf8', callback) can also be used
var str = data.toString();
var array = str.split('\n');
var len = array.length-1;
console.log(len);
})

