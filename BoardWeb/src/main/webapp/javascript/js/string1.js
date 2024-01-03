// string1.js

let str1 = "Hello";
console.log(str1, typeof str1);
let str2 = new String("Hello");
console.log(str2, typeof str2);

console.log(str1 === str2);

console.log(str2.substring(1, 3));

let word = "     Hello, World ";
console.log(word.trim());
console.log(word.trimStart());
console.log(word.trimEnd());
// const obj = new Object(); {}
// const reg = new RegExp(); /값/
console.log(word.replace('o', ''));
console.log(word.replace(/o/, ''));
console.log(word.replace(/o/g, ''));
console.log(word.replace(/\s/g, ''));

word = '  how are you   to day  everyone.  ';
console.log(word.split(' ').filter(val => val).join(' '));


// slice().
const st1 = 'This is the only one story';
console.log(st1.slice(8, 11)); // 'the'를 반환.
//시작 인덱스가 음수인 경우 빈 문자열 반환.
console.log(st1.slice(-8, 11)); // 'the'를 반환.

//시작 인덱스가 끝인덱스보다 크거나 같은 경우 빈 문자열을 반환.(끝 인덱스가 반드시 커야 함).
console.log(st1.slice(10, 4)); // 'the'를 반환.
//파라메터가 1개만 있을 경우 시작 인덱스 값이 됨.
//끝 인덱스가 생략된 것으로 끝 인덱스는 문자열 길이값이 사용됨.
console.log(st1.slice(30)) // ''를 반환.

//끝 인덱스는 마이너스 값을 사용할 수 있음.
//마이너스 값일 경우 (문자열 길이 + 마이너스 값) 이 끝 인덱스 값이 됨.
console.log(st1.slice(0, -10)); // 'This is the only'를 반환.

// substr().
console.log(st1, substr(8, 11)); // 'the only on'를 반환.
console.log(st1, substr(11, 8)); // ' only on'를 반환.

//파라메터 값이 음수이므로 0으로 먼저 변경하므로 빈 문자열을 반환
console.log(st1, substr(11, -8)); // ''를 반환.

//시작 인덱스가 음수이므로 문자열 끝에서 10만큼 왼쪽으로 이동한 위치부터 8개의 문자열을 반환
console.log(st1, substr(-10, 8)); // ' one sto'를 반환.

//파라메터가 1개만 있을 경우 시작 인덱스 값이 됨. 길이가 생략된 것으로 문자열 길이값이 적용됨.
// 따라서 문자열 시작 인덱스부터 문자열 끝까지가 반환됨.
console.log(st1, substr(10)); // 'e only one story'를 반환.

//끝 인덱스는 마이너스 값을 사용할 수 있음. substr(0,0) 문자열을 반환.
console.log(st1, substr(0, -10)); // ''를 반환

//마지막 인덱스+1(문자열 길이값) 보다 큰 값은 마지막 인덱스+1 로 대체.
console.log(st1, substr(8, 100)); // 'the only one story'를 반환.

//파라메터가 없을 경우 전체 문자열을 반환
console.log(st1, substr()); // 'This is the only one story'를 반환.



//찾은 문자열의 시작 위치 얻기

const st2 = 'good morning, good afternoon, good evening, and good night';
console.log(st2.indexOf('even')); // 35를 반환
//문자열 뒤에서부터 'good' 이 처음 나오는 시작 위치를 반환함.
console.log(st2.indexOf('good')); // 48를 반환
console.log(st2.indexOf('dawn')); // -1를 반환함

//첫번째 'good'과 두번째 'good'을 건너뛰고 3번째 'good'의 시작 인덱스를 반환합니다.
console.log(st2.indexOf('good', 15)); // 30을 반환합니다.

//특정 위치의 문자 1개를 얻기
console.log(st2.charAt(30)); // 'g'를 반환.
console.log(st2.charAt(100)); // ''를 반환.

//특정 문자열이 포함 되었는지 알기
console.log(st2.includes('even')); // 'true'를 반환.
console.log(st2.includes('dawn')); // 'false'를 반환.

//대소문자 구분없이 문자열 위치 찾기
const sT2 = 'good morning, good afternoon, GOOD EVENING, AND GOOD NIGHT';
console.log(st2.toUpperCase().indexOf('good')); // 0을 반환.
console.log(st2.toUpperCase().indexOf('GOOD')); // 0을 반환.
console.log(st2.search('GOOD')); // 31을 반환.
console.log(st2.search(/GOOD/i)); // 0을 반환.

//정규 표현식과 일치하는 모든 문자열을 찾기
const St2 = "bad MORNING, GOOD AFTERNOON, good evening, and good night";
// 'good' 뒤에 공백 1개가 있고 그 뒤에 단어1개가 있는 패턴인 것을 모두 찾음
console.log(St2.match(/good\s\w+/gi));

