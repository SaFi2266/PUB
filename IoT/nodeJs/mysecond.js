var len = process.argv.length;
var sum = 0;
for (i = 2; i<len; i++) {
sum = sum + Number(process.argv[i]);
}
console.log(sum);
//console.log(process.argv[0]);
//console.log(process.argv[1]);

