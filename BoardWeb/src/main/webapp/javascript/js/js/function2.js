// function2.js
let members = `[{"id":1,"first_name":"Holmes","last_name":"Abrahart","email":"habrahart0@comsenz.com","gender":"Male","salary":2800},
{"id":2,"first_name":"Viviyan","last_name":"Johnikin","email":"vjohnikin1@columbia.edu","gender":"Female","salary":3938},
{"id":3,"first_name":"Araldo","last_name":"Turrell","email":"aturrell2@symantec.com","gender":"Male","salary":3189},
{"id":4,"first_name":"Harald","last_name":"Sibbs","email":"hsibbs3@123-reg.co.uk","gender":"Male","salary":9864},
{"id":5,"first_name":"Godfry","last_name":"Dunstan","email":"gdunstan4@businesswire.com","gender":"Male","salary":8485},
{"id":6,"first_name":"Marijo","last_name":"Richardes","email":"mrichardes5@yellowbook.com","gender":"Female","salary":9149},
{"id":7,"first_name":"Griffin","last_name":"Setterington","email":"gsetterington6@umich.edu","gender":"Male","salary":9522},
{"id":8,"first_name":"Phillis","last_name":"Logan","email":"plogan7@hud.gov","gender":"Female","salary":7687},
{"id":9,"first_name":"Fleurette","last_name":"Tremain","email":"ftremain8@howstuffworks.com","gender":"Female","salary":2449},
{"id":10,"first_name":"Iseabal","last_name":"Doumerc","email":"idoumerc9@elegantthemes.com","gender":"Female","salary":8540},
{"id":11,"first_name":"Jemimah","last_name":"Dengel","email":"jdengela@shutterfly.com","gender":"Female","salary":2882},
{"id":12,"first_name":"Charlotte","last_name":"Devenish","email":"cdevenishb@livejournal.com","gender":"Female","salary":8654},
{"id":13,"first_name":"Whitney","last_name":"Ankrett","email":"wankrettc@ucsd.edu","gender":"Male","salary":2838},
{"id":14,"first_name":"Rhianon","last_name":"Yukhnin","email":"ryukhnind@nps.gov","gender":"Female","salary":3477},
{"id":15,"first_name":"Cobby","last_name":"Thomtson","email":"cthomtsone@examiner.com","gender":"Male","salary":4749}]`;

let memberAry = JSON.parse(members); // 문자열 -> 객체변환.
console.log(memberAry);

let titles = ['아이디', '이름', '성씨', '이메일', '성별', '급여']

function makeHeader(fields = [], pos = {}) {
    let tr = document.createElement('tr');
    fields.forEach(function (field) {
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    });
    pos.appendChild(tr);
}

makeHeader(titles, document.getElementById('theader'));

function makeBody(data = [], post = {}) {
    data.forEach(function (member) {
        let tr = document.createElement('tr');
        // tr에 속성 지정.
        if (member.gender == 'Female') {
            tr.setAttribute('style', 'background-color:aqua');
        }
        else if (member.gender == 'Male') {
            tr.setAttribute('style', 'background-color:pink');
        }
        for (let ele in member) {
            let td = document.createElement('td');
            td.innerText = member[ele];
            tr.appendChild(td);
        }
        post.appendChild(tr);
    });
}

makeBody(memberAry, document.getElementById('tbody'));

