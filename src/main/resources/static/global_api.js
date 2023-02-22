'use strict'

/* data 변환 */
const dataConvert = (params, type) => {
    if(type === 'json') {
        return JSON.stringify(params);
    } else if(type === 'formData') {
        return new URLSearchParams(params).toString();
    }
}

/* contentType 변환 */
const contentTypeConvert = (type) => {
    if(type === 'json') {
        return 'application/json;charset=UTF-8';
    } else if(type === 'formData') {
        return 'application/x-www-form-urlencoded; charset=UTF-8';
    }
}

/*
 * 동기 - POST
 * @param url - 호출 주소
 * @param data - 요청 데이터
 * @param type - 요청 데이터 타입 ['json', 'formData']
 */
const fetchPostCall = async (url, data, type) => {
    const init = {
        method : 'POST',
        cache : 'no-cache',
        headers : {
            'Content-Type' : contentTypeConvert(type)
        },
        body : dataConvert(data, type)
    };
    let result = null;
    await fetch(url, init)
        .then(res => {return res.json();})
        .then(data => result = data)
        .catch(err => alert(err))
    return result;
}

/*
 * 동기(파일 포함) - POST
 * @param url - 호출 주소
 * @param data - 요청 데이터
 */
const fetchPostCallMulti = async (url, data) => {
    const init = {
        method : 'POST',
        body : data
    };
    let result = null;
    await fetch(url, init)
        .then(res => {return res.json();})
        .then(data => result = data)
        .catch(err => alert(err))
    return result;
}

/*
 * 비동기 - POST
 * @param url - 호출 주소
 * @param data - 요청 데이터
 * @param type - 요청 데이터 타입 ['json', 'formData']
 */
const fetchPostCallAsync = (url, data, type) => {
    const init = {
        method : 'POST',
        cache : 'no-cache',
        headers : {
            'Content-Type' : contentTypeConvert(type)
        },
        body : dataConvert(data, type)
    };
    fetch(url, init)
        .then(res => {return res.json();})
        .then(data => console.log(data))
        .catch(err => alert(err))
}

/*
 * 동기 - GET
 * @param url - 호출 주소
 */
const fetchGetCall = async (url) => {
    let result = null;
    await fetch(url)
        .then(res => {return res.json();})
        .then(data => result = data)
        .catch(err => alert(err))
    return result;
}

/*
 * 비동기 - GET
 * @param url - 호출 주소
 */
const fetchGetCallAsync = (url) => {
    fetch(url)
        .then(res => {return res.json();})
        .then(data => console.log(data))
        .catch(err => alert(err))
}