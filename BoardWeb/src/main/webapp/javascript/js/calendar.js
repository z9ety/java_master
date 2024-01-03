//calendar.js

let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];

let lastDate = getLastDate(1);
let firstDay = getFirstDay(2);

function getLastDate(month) {
    // 월입력 => 마지막날을 반환. 31 29 31
    switch (month) {
        case 1:
            return 31;
            break;
        case 2:
            return 29;
            break;
        case 3:
            return 31;
            break;
        default:

    }
}
console.log(lastDate);

function getFirstDay(month) {
    // 월입력 => 1일의 위치(공백이 몇개 반환);
    switch (month) {
        case 1:
            return 1;
            break;
        case 2:
            return 4;
            break;
        case 3:
            return 5;
            break;
        default:
    }
}
console.log(firstDay);

//herder 생성.
function makeTitle(dayAry = [], pos = {}) {
    let tr = document.createElement('tr');
    tr.setAttribute('style', 'text-align: center;');
    tr.setAttribute('style', 'background: #ccc;');
    dayAry.forEach(function (day) {
        let th = document.createElement('th');
        th.innerText = day;
        tr.appendChild(th);
        th.setAttribute('style', 'width: 40px;');
    });
    pos.appendChild(tr);
}

function makeCalendar(month) {
    makeTitle(days, document.getElementById('theader'));
    makeBody(month, document.getElementById('tbody'));
}
makeCalendar(3);

// 날짜 생성.
function makeBody(month = [], pos = {}) {
    let tr = document.createElement('tr');
    // 공백.
    let firstDay = getFirstDay(month);
    for (let i = 0; i < firstDay; i++) {
        let td = document.createElement('td');
        td.innerText = "";
        tr.appendChild(td);
    };

    // 날짜.
    let lastDate = getLastDate(month);
    for (let i = 1; i <= lastDate; i++) {
        let td = document.createElement('td');
        td.innerText = i;
        tr.appendChild(td);
        tr.setAttribute('style', 'text-align: center;');

        if ((i + firstDay) % 7 == 1) {
            td.setAttribute('style', 'background: red;');
        }

        else if ((i + firstDay) % 7 == 0) {
            tr = document.createElement('tr');
            td.setAttribute('style', 'background: aqua;');
        }
        pos.appendChild(tr);
    }
}