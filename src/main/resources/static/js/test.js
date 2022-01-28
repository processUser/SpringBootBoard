let user_uid = /*[[ ${session.loginUser.nm} ]]*/ ""
window.onload = () => {
    let aaaElem = document.querySelector('.aaa');
    console.log(aaaElem)
    aaaElem.innerHTML = user_uid;
}

<script>
    let user_uid = "[[${session.loginUser.nm}]]"
    // let user_uid = /*[[ ${session.loginUser.nm} ]]*/ " ";
    // let user_uid = "a"

    let aaaElem = document.querySelector('.aaa');
    console.log(user_uid)
    aaaElem.innerHTML = user_uid;
</script>