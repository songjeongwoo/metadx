if(localStorage.getItem("memberType") != "admin"){
    alert("접근 권한이 없습니다.");
    self.location = "http://localhost:8080/member/login.html"
    if(localStorage.getItem("accessToken") == null && localStorage.getItem("refreshToken") == null && localStorage.getItem("email") == null)
    {
        alert("토큰이 없습니다. 다시 로그인해주세요");
        self.location = "http://localhost:8080/member/login.html"
    }
}