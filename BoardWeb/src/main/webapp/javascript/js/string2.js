// string2.js

const keyword = '홍';
const wordAry = ['사과', '홍씨', '홍장군', '김시홍', '감자']
// 1. 배열에서 '홍'이 들어간 단어의 갯수를 구하기.
let hongs = 0;
wordAry.forEach(function (hong) {
    if (hong.includes(keyword)) {
        hongs += 1;
        console.log(hong);
    }
})
console.log(hongs);


const url = 'http://localhost/BoardWeb/index.jsp?x=12&y=23';
// 2. url에서 파라미터(x, y)의 값을 찾기.
console.log("x: " + url.substr(url.indexOf('x=') + 2, 2));
console.log("y: " + url.substr(url.indexOf('y=') + 2, 2));


const word = '안녕하세요xx만나서xx반갑습x니x다.';
// 3. "안녕하세요 만나서 반갑습니다." 문장으로 변환하기.
let rewd = word.replace(/xx/g, ' ').replace(/x/g, '');
console.log(rewd);