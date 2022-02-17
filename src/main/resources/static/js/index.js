// const path = "http://localhost:8080/api"
const path = "http://150.158.193.51:8080/api"

function insertSalary() {
    let position = prompt(`请输入职位等级`);
    let salary = prompt(`基本工资`)
    if (position.length === 0 || salary.length === 0) {
        alert('禁止输入为空')
        return;
    }
    axios({
        withCredentials: true,
        method: 'post',
        url: path + "/Salary/addOneItem",
        data: {
            position: position,
            salary: salary
        }
    }).then(res => {
        getSalaryList.click();
        if (res.data.resultCode === 200) {
            alert(res.data.data)

        } else {
            alert(res.data.data)
        }
    })
}

function deleteSalary(a, b) {
    var position = a
    // var position = prompt(`请输入职位等级`)
    // var salary = prompt(`基本工资`)
    var salary = b
    if (position.length === 0 || salary.length === 0) {
        alert('禁止输入为空')
        return;
    }
    let list = [{'position': position, 'salary': Number(salary)}];
    axios({
        withCredentials: true,
        method: 'post',
        url: path + "/Salary/deleteByObj",
        data: list
    }).then(res => {
        getSalaryList.click();
        if (res.data.resultCode === 200) {
            alert(res.data.data)
        } else {
            alert(res.data.data)
        }
    })
}

function updateSalary(a) {
    // var position = prompt(`请输入职位等级`)
    var position = a
    var salary = prompt(`修改的基本工资`)
    if (position.length === 0 || salary <=0) {
        alert('禁止输入为空')
        return;
    }
    let list = [{'position': position, 'salary': Number(salary)}];
    axios({
        withCredentials: true,
        method: 'post',
        url: path + "/Salary/updateBasicSalary",
        data: list
    }).then(res => {
        getSalaryList.click();
        if (res.data.resultCode === 200) {
            alert(res.data.data)
        } else {
            alert(res.data.data)
        }
    })
}

function insertList() {
    var name = prompt(`员工姓名`)
    var position = prompt(`员工职位等级`)
    if (position.length === 0 || name.length === 0) {
        alert('禁止输入为空')
        return;
    }

    axios({
        method: 'post',
        url: path + "/employee/addInfo",
        data: {
            position: position,
            name: name
        },
        withCredentials: true,
    }).then(res => {
        getList.click()
        if (res.data.resultCode === 200) {
            alert(res.data.data)
        } else {
            alert(res.data.data)
        }
    })
}

function deleteList(a, b) {
    // var id = prompt(`员工id`)
    // var name = prompt(`员工姓名`)
    var id = a
    var name = b
    if (id.length === 0 || name.length === 0) {
        alert('禁止输入为空')
        return;
    }
    axios({
        method: 'post',
        url: path + "/employee/resign",
        data: {
            id: id,
            name: name
        },
        withCredentials: true
    }).then(res => {
        getList.click()
        if (res.data.resultCode === 200) {
            alert(res.data.data)
        } else {
            alert(res.data.data)
        }
    })
}

function updateList(a, b) {
    // var id = prompt(`员工id`)
    // var name = prompt(`员工姓名`)
    var id = a
    var name = b
    var position = prompt(`员工职位等级`)
    if (id.length === 0 || name.length === 0||position.length===0) {
        alert('禁止输入为空')
        return;
    }

    axios({
        withCredentials: true,
        method: 'post',
        url: path + "/employee/modify",
        data: {
            id: id,
            name: name,
            position: position
        }
    }).then(res => {
        getList.click()
        if (res.data.resultCode === 200) {
            alert(res.data.data)
        } else {
            alert(res.data.data)
        }
    })
}

function getAttendanceByID(id) {
    axios({
        withCredentials: true,
        method: 'get',
        url: path + "/calculation/getAttendanceByID?id=" + id,
    }).then(res => {
        if (res.data.resultCode === 200) {
            let list = res.data.data
            let table = document.querySelector("table");
            let str = "<tr class=\"tr_title\" id=\"tr_title\">" +
                "<th class='th_font'>工号</th>" +
                "<th class='th_font'>名字</th>" +
                "<th class='th_font'>打卡时间</th>" +
                "<th></th>" +
                "</tr>"
            for (let i = 0; i < list.length; i++) {
                str = str +
                    "<tr>" +
                    "<td>" + list[i].id + "</td>" +
                    "<td>" + list[i].name + "</td>" +
                    "<td>" + list[i].dtime + "</td>" +
                    "<td></td>" +
                    "</tr>"
            }

            table.innerHTML = str
            Features0.style.display = "none";
            Features1.style.display = "none";
            Count.style.display = "none";

        } else {
            alert(res.data.data)
        }
    })
}

function selectLike(value) {
    axios({
        withCredentials: true,
        method: 'get',
        url: path + "/employee/selectLike?value=" + value,
    }).then(res => {
        if (res.data.resultCode === 200) {
            let list = res.data.data
            let table = document.querySelector("table");
            let str = "<tr class=\"tr_title\" id=\"tr_title\">" +
                "<th class='th_font'>工号</th>" +
                "<th class='th_font'>名字</th>" +
                "<th class='th_font'>职位</th>" +
                "<th class='th_font'>基本薪资</th>" +
                "<th class='th_font'>入职时间</th>" +
                "<th>操</th>" +
                "<th>作</th>" +
                "</tr>"
            for (let i = 0; i < list.length; i++) {
                str = str +
                    "<tr>" +
                    "<td>" + list[i].id + "</td>" +
                    "<td>" + list[i].name + "</td>" +
                    "<td>" + list[i].position + "</td>" +
                    "<td>" + list[i].salary + "</td>" +
                    "<td>" + list[i].entryTime + "</td>" +
                    "<td>" +
                    "<div id=\"Features0\">\n" +
                    "        <button class='jbtn' onclick='deleteList(\"" + list[i].id + "\",\"" + list[i].name + "\")'>删除</button>\n" +
                    "        <button class='jbtn' onclick='updateList(\"" + list[i].id + "\",\"" + list[i].name + "\")'>更新</button>\n" +

                    "    </div>" +
                    "</td>" +
                    "<td>" +
                    "<div>" +
                    "        <button class='jbtn' onclick=''>税后工资</button>\n" +
                    "        <button class='jbtn' onclick='getAttendanceByID(\"" + list[i].id + "\")'>打卡情况</button>\n" +
                    "    </div>" +
                    "</td>" +
                    "</tr>"
            }

            table.innerHTML = str
            Features0.style.display = "none";
            Features1.style.display = "block";
            Count.style.display = "none";

        } else {
            alert(res.data.data)
        }
    })
}


window.onload = () => {


    let logout = document.querySelector("#logout")
    let getSalaryList = document.querySelector("#getSalaryList")
    let getPositionCount = document.querySelector("#getPositionCount")
    let getList = document.querySelector("#getList")
    let getAttendance = document.querySelector("#getAttendance")
    let Features0 = document.querySelector("#Features0")
    let Features1 = document.querySelector("#Features1")
    let search = document.querySelector(".search");
    let Count = document.querySelector("#count");

    logout.addEventListener("click", () => {
        axios({
            method: 'get',
            url: path + "/user/logout",
            withCredentials: true,
        }).then(res => {
            if (res.data.resultCode === 200) {
                alert(res.data.data)
                window.location.href = "../../pages/login.html"
            } else {
                alert(res.data.data)
                window.location.href = "../../pages/login.html"
            }
        })
    })

    getSalaryList.addEventListener("click", () => {
        axios({
            method: 'get',
            url: path + "/Salary/getSalaryList",
            withCredentials: true,
        }).then(res => {
            if (res.data.resultCode === 200) {
                let list = res.data.data
                let table = document.querySelector("table");

                let str = "<tr class=\"tr_title\" id=\"tr_title\">" +
                    "<th class='th_font'>职位</th>" +
                    "<th class='th_font'>基本薪资</th>" +
                    "<th>操作</th>" +
                    "</tr>"
                for (let i = 0; i < list.length; i++) {
                    let position = list[i].position + ""
                    let salary = list[i].salary
                    str = str +
                        "<tr>" +
                        "<td>" + position + "</td>" +
                        "<td>" + salary + "</td>" +
                        "<td>" +
                        "<div id=\"Features0\">\n" +
                        "        <button  class='jbtn' onclick='deleteSalary(\"" + position + "\"," + salary + ")'>删除</button>\n" +
                        "        <button class='jbtn' onclick='updateSalary(\"" + position + "\")'>更新</button>\n" +
                        "    </div>" +
                        "</td>" +
                        "</tr>"
                }

                table.innerHTML = str
                Features0.style.display = "block";
                Features1.style.display = "none";
                Count.style.display = "none";

            } else {
                alert(res.data.data)
                window.location.href = "../../pages/login.html"
            }
        })
    })

    getPositionCount.addEventListener("click", () => {
        axios({
            method: 'get',
            url: path + "/Salary/getPositionCount",
            withCredentials: true,
        }).then(res => {
            if (res.data.resultCode === 200) {
                let list = res.data.data.list
                let count = res.data.data.count
                let table = document.querySelector("table");

                let str = "<tr class=\"tr_title\" id=\"tr_title\">" +
                    "<th class='th_font'>职位</th>" +
                    "<th class='th_font'>基本薪资</th>" +
                    "<th class='th_font'>人数</th>" +
                    "</tr>"
                for (let i = 0; i < list.length; i++) {
                    let position = list[i].position + ""
                    let salary = list[i].salary
                    let count = list[i].count
                    str = str +
                        "<tr>" +
                        "<td>" + position + "</td>" +
                        "<td>" + salary + "</td>" +
                        "<td>" + count + "</td>" +
                        "</tr>"
                }
                Count.innerHTML = count;
                table.innerHTML = str
                Features0.style.display = "none";
                Features1.style.display = "none";
                Count.style.display = "block";

            } else {
                alert(res.data.data)
            }
        })
    })

    getList.addEventListener("click", () => {
        axios({
            method: 'get',
            url: path + "/employee/getList",
            withCredentials: true,
        }).then(res => {
            if (res.data.resultCode === 200) {
                let list = res.data.data
                let table = document.querySelector("table");
                let str = "<tr class=\"tr_title\" id=\"tr_title\">" +
                    "<th class='th_font'>工号</th>" +
                    "<th class='th_font'>名字</th>" +
                    "<th class='th_font'>职位</th>" +
                    "<th class='th_font'>基本薪资</th>" +
                    "<th class='th_font'>入职时间</th>" +
                    "<th>操</th>" +
                    "<th>作</th>" +
                    "</tr>"
                for (let i = 0; i < list.length; i++) {
                    str = str +
                        "<tr>" +
                        "<td>" + list[i].id + "</td>" +
                        "<td>" + list[i].name + "</td>" +
                        "<td>" + list[i].position + "</td>" +
                        "<td>" + list[i].salary + "</td>" +
                        "<td>" + list[i].entryTime + "</td>" +
                        "<td>" +
                        "<div id=\"Features0\">\n" +
                        "        <button class='jbtn' onclick='deleteList(\"" + list[i].id + "\",\"" + list[i].name + "\")'>删除</button>\n" +
                        "        <button class='jbtn' onclick='updateList(\"" + list[i].id + "\",\"" + list[i].name + "\")'>更新</button>\n" +
                        "    </div>" +
                        "</td>" +
                        "<td>" +
                        "<div>" +
                        "        <button class='jbtn' onclick=''>税后工资</button>\n" +
                        "        <button class='jbtn' onclick='getAttendanceByID(\"" + list[i].id + "\")'>打卡情况</button>\n" +
                        "    </div>" +
                        "</td>" +
                        "</tr>"
                }

                table.innerHTML = str
                Features0.style.display = "none";
                Features1.style.display = "block";
                Count.style.display = "none";

            } else {
                alert(res.data.data)
                window.location.href = "../../pages/login.html"
            }
        })
    })

    getAttendance.addEventListener("click", () => {
        axios({
            method: 'get',
            url: path + "/calculation/getAttendance",
            withCredentials: true,
        }).then(res => {
            if (res.data.resultCode === 200) {
                let list = res.data.data
                let table = document.querySelector("table");
                let str = "<tr class=\"tr_title\" id=\"tr_title\">" +
                    "<th class='th_font'>工号</th>" +
                    "<th class='th_font'>名字</th>" +
                    "<th class='th_font'>打卡时间</th>" +
                    "<th></th>" +
                    "</tr>"
                for (let i = 0; i < list.length; i++) {
                    str = str +
                        "<tr>" +
                        "<td>" + list[i].id + "</td>" +
                        "<td>" + list[i].name + "</td>" +
                        "<td>" + list[i].dtime + "</td>" +
                        "<td></td>" +
                        "</tr>"
                }

                table.innerHTML = str
                Features0.style.display = "none";
                Features1.style.display = "none";
                Count.style.display = "none";

            } else {
                alert(res.data.data)
            }
        })
    })

    getSalaryList.click();

    let insert0 = document.querySelector("#insert0")
    insert0.addEventListener("click", insertSalary)

    let insert1 = document.querySelector("#insert1")
    insert1.addEventListener("click", insertList)

    //为输入框事件设置回车响应
    search.addEventListener("keypress", e => {
        if (e.which === 13)
            selectLike(search.value);
    });

}
