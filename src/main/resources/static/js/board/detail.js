(function () {
    'use strict'
    const myUrl = new URL(window.location.href);
    const iboard = myUrl.searchParams.get('iboard');

    const boardDetailElem = document.querySelector('#board_detail');

    const commentFormContainerElem = document.querySelector('#comment_form_container');

    // 글 상세 페이지
    const getItem = () => {
        fetch(`/board/detail_item?iboard=${iboard}`).then(res =>res.text())
            .then(data => {
                boardDetailElem.innerHTML= data;
            })
    }
    getItem();

    // 댓글 입력
    if(commentFormContainerElem) {
        const commentSubmitBtnElem = commentFormContainerElem.querySelector('button');
        const commentCtntElem = commentFormContainerElem.querySelector('input[name="ctnt"]');

        commentSubmitBtnElem.addEventListener('click', e => {
            const ctnt = commentCtntElem.value;

            const param = {
                iboard, ctnt
            }
            myFetch.post('/ajax/comment', data => {
                switch (data.result) {
                    case 0:
                        alert('댓글 전송에 실패하였습니다.');
                        break;
                    case 1:
                        commentCtntElem.value ='';
                        break;
                }
            }, param);
        })
    }

    //댓글 리스트

    const getCommentList = () => {
        myFetch.get('/ajax/comment',list =>{
            console.log(list);
            makeCommentRecordList(list)
        },{iboard});
    }
    getCommentList();

    const makeCommentRecordList = list => {
        const commentListElem = document.querySelector('#comment_list');
        const tbodyElem = commentListElem.querySelector('table > tbody');

        list.forEach((item) =>{
            const trElem = document.createElement('tr');
            tbodyElem.append(trElem);

            trElem.innerHTML = `
                <td>${item.ctnt}</td>
                <td>${item.writernm}</td>
                <td>${item.rdt}</td>
                <td></td>
            `;
        });
    }

})()