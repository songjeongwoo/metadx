// header 생성
document.querySelector("header").innerHTML =
    `<div class="row justify-content-between">
        <div class="col">
            <a class="logoBtn" href="/board/list.html">
                <img src="../res/logo.png" id="logoImg" alt="로고이미지">
            </a>
            <a class="adminBtn ml-3 mb-0" href="http://localhost:8080/admin/index.html" hidden>관리자 화면</a>
        </div>
        <div class="col d-flex justify-content-end mr-5 mt-4" id="menuBtn">
            <a class="registerBtn mr-3 mb-0" href="http://localhost:8080/member/register.html">회원가입</a>
            <a class="loginBtn mb-0" href="http://localhost:8080/member/login.html">로그인</a>
            <a class="boardBtn mr-3 mb-0" href="http://localhost:8080/board/list.html" hidden>게시물 보러가기</a>
            <a class="logoutBtn mb-0" href="#" hidden>로그아웃</a>
        </div>
    </div>`

// 로그인한 경우
const member = localStorage.getItem("email")
const memberType = localStorage.getItem("memberType")

if(member) {
    document.querySelector(".registerBtn").setAttribute("hidden", "hidden")
    document.querySelector(".loginBtn").setAttribute("hidden", "hidden")
    document.querySelector(".boardBtn").removeAttribute("hidden")
    document.querySelector(".logoutBtn").removeAttribute("hidden")

    if(memberType == "admin") {
        document.querySelector(".adminBtn").removeAttribute("hidden")
    }
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