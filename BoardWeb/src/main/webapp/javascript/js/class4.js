// class4.js

const friend = {
    name: "홍길동",
    age: 20,
    hobbies: ['독서', '운동', '영화'],
    pets: [{ name: '야옹이', gender: 'M', friends: ['검양이', '빨양이'] }, { name: '멍멍이', gender: 'F' }],
    showHobby() {
        return `${this.hobbies[0]}, ${this.hobbies[1]}, ${this.hobbies[2]}`;
    }
}
friend.pets[0]['friends'][2] = '노랑이';
delete friend.age;
friend.ages = 20; // 속성추가.
friend.showFriends = function () {
    console.log(this);
}

console.log(friend);

// 참조값을 복사.
const fcopy = friend;
fcopy.age = 22;
console.log(fcopy);

// 객체를 복사.
const fcopy2 = Object.assign({ bloodType: 'O' }, friend); // (객체 초기값, 복사할 객체)
fcopy2.age = 24;
console.log(fcopy2);

//속성추가.
Object.defineProperty(friend, 'height', {
    get: function () {
        return this._height;
    },
    set: function (value) {
        if (value <= 0) {
            alert('error');
        } else {
            this._height = value;
        }
    }
});
friend.height = 162;
console.log(friend.height);