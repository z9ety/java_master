// array1.js
// ary = []
const ary = [1, 2, '3', new Date()];

const numAry = [10, 20, 30, 40];
numAry.push(30);
numAry.unshift(40);
numAry.pop(); // 마지막 요소 삭제.
numAry.shift(); // 첫 요소 삭제.
// numAry.splice(0);
// numAry.length = 10;

const numAry2 = [50, 60];

// const numAry3 = numAry.concat(numAry2);
// numAry에 numAry2을 추가.
numAry2.forEach(addAry => numAry.push(addAry));
console.log(numAry);