// function4.js

// 달력을 생성하는 객체.
const cal = {
    days: ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'],
    makeCalendar: function (month) {
        this.makeTitle(this.days, document.getElementById('theader'));
        this.makeBody(month, document.getElementById('tbody'));
    },
    makeTitle: function (fields, pos) {
        let tr = document.createElement('tr');
        tr.setAttribute('style', 'text-align: center;');
        tr.setAttribute('style', 'background: #ccc;');
        fields.forEach(function (field) {
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
            th.setAttribute('style', 'width: 40px;');
        });

        pos.appendChild(tr);
    },
    makeBody: function (month, pos) {
        let tr = document.createElement('tr');
        // 공백.
        let firstDay = this.getFirstDay(month);
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = "";
            tr.appendChild(td);
        };

        // 날짜.
        let lastDate = this.getLastDate(month);
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
    }, // makeBody.
    getFirstDay(month) {
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
    }, // getFirstDay.

    getLastDate(month) {
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
    } // getLastDate.
}
cal.makeCalendar(3);