var myModule = require('./mymodule.js');
var dir = process.argv[2];
var ext = process.argv[3];

myModule(dir, ext, function callback(err, data) {
		if (err) {
			console.log(err);
    } else {
        for(var i=0; i<data.length; i++) {
			console.log(data[i]);
}
}
});

