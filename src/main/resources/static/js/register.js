// const path = "http://localhost:8080/api"
const path = "http://150.158.193.51:8080/api"

window.onload = () => {


    let submit = document.querySelector("#submit")

    submit.addEventListener("click", () => {
        let account = document.querySelector("#account").value
        console.log(account);
        let password = document.querySelector("#password").value
        console.log(password);
        axios({
            method: 'post',
            url: path + "/user/Register",
            withCredentials: true,
            data: {
                account: account,
                password: password
            }
        }).then(res => {
            if (res.data.resultCode === 200) {
                alert(res.data.data)
                window.location.href = "../pages/login.html"
            } else {
                alert(res.data.data)
            }
        })
    })

    let register_img = document.querySelector("#register_img")
    register_img.addEventListener("click", () => {
        window.location.href = "../pages/login.html"
    })
}
