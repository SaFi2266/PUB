var myModule = require("./mymodule.js");

var directory = process.argv[2];
var fileType = "." + process.argv[3];

myModule(directory, fileType, function callback(err, list){
    if(err) {
        console.log(err);
    } else {

        for(var i=0; i<list.length; i++) {
            console.log(list[i]);
        }
    }
});
