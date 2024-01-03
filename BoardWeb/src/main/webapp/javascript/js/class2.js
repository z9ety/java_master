// class2.js   
let year = 2024;
let month = 2;

class Calendar {
    constructor(year, month) {
        this.year = year;
        this.month = month;
    }
    days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
    makeCalendar() {
        this.makeTitle(document.getElementById('theader'));
        this.makeBody(document.getElementById('tbody'));
    }
    makeTitle(pos) {
        let tr = document.createElement('tr');
        tr.setAttribute('style', 'text-align: center;');
        tr.setAttribute('style', 'background: #ccc;');
        this.days.forEach(function (day) {
            let th = document.createElement('th');
            th.innerText = day;
            tr.appendChild(th);
            th.setAttribute('style', 'width: 40px;');
        });
        pos.appendChild(tr);
    }

    makeBody(pos = {}) {
        let tr = document.createElement('tr');
        // 공백.
        let firstDay = this.getFirstDay();
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = "";
            tr.appendChild(td);
        };
    
        // 날짜.
        let lastDate = this.getLastDate();
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

    getLastDate() {
        return new Date(this.year, this.month, 0).getDate();
    }
    getFirstDay() {
        return new Date(this.year, this.month -1, 1).getDay();
    }
}
const cal = new Calendar(year, month);
cal.makeCalendar();