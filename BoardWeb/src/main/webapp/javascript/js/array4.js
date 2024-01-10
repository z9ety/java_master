// array4.js
// map, filter, find, indexOf, some, every

const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘'

const strAry = str.split(', ');
console.log(strAry);
// 1. 콘이라는 이름이 몇번?
let ncons = strAry.filter(item => item.includes('콘') && item.length == 1);
console.log(`콘은 ${ncons.length}명 있습니다`);

// 2. 이름이 3자이상이 몇명?
let threes = strAry.filter(item => item.length >= 3);
console.log(`이름이 3자 이상인 사람은 ${threes.length}명 있습니다`);

// 3. 2자인 이름이 있는지 여부?
let twoname = strAry.some(acc => {
    return acc.length == 2;
});
if(twoname){
    console.log('2자인 이름이 있습니다');
}else{
    console.log('2자인 이름이 없습니다.');
}
// 4. {no: 1, name: '펭수'} 형태의 값을 가지는 배열을 생성. 결과값을 strAry에 대입.
// map
const Ary = strAry.map((item, idx) =>{
    return{
        no: idx,
        name: item
    }
})
console.log(Ary);