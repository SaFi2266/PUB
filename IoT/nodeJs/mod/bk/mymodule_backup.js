module.exports = function (dirName, extStr, callback) { 

var fs = require('fs');
var path = require('path');
var array = [];

fs.readdir(dirName, function callback (err, data) { 
  if (err) {
	callback(err);
	}else{
    		var len = data.length;
      		for(i =0; i < len; i++) {
      			var ff = data[i];
      			var ex = path.extname(ff);
        		if (ex == "."+extStr) {
	    		array.push(ff);	
			}
		}
	}
	return callback(err, array);
   	});
};
