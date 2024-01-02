//function1.js

function sum()  {
    let result = 0;
    // result = num1 + num2;
    // console.log(result);
    console.log(arguments); // arguments 사용하지 말것
    for(let arg of arguments){
        result += arg;
    }
    return result;
}

let result = sum(11,22,33,44,55,66);
console.log('결과는' + result);

console.log("배열의 총합:", + sum3);

let myfunc = function (callback){
    let num1 = 10;
    let num2 = 5;
    result = callback(num1,num2);
    return result; 
}

let sumfunc = function (n1, n2){
    return n1 + n2;
}
let munusfunc =function (n1, n2){
    return n1 - n2;
}

console.log('함수결과 ' + myfunc(minusfunc));