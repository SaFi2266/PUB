var fs = require('fs');
var buf = fs.readFileSync(process.argv[2]);
var str = buf.toString();
var array = str.split('\n');
var len = array.length-1;
console.log(len);
