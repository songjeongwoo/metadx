// 로그인한 경우
const member = localStorage.getItem("email")
const memberType = localStorage.getItem("memberType")

if(member) {
    document.querySelector(".boardBtn").removeAttribute("hidden")
    document.querySelector(".logoutBtn").removeAttribute("hidden")
}

// 로그아웃 시
document.querySelector(".logoutBtn").addEventListener("click", (e) => {

    e.preventDefault();
    e.stopPropagation();
    window.localStorage.removeItem('email');
    window.localStorage.removeItem('accessToken');
    window.localStorage.removeItem('refreshToken');
    window.localStorage.removeItem("memberType");
    self.location = "http://localhost:8080/member/login.html"

}, false)