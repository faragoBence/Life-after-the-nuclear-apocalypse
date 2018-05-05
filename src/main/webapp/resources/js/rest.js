function rest() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onRestResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'protected/rest');
    xhr.send();
}

function onRestResponse() {
    if (this.status === OK) {
        const dto = JSON.parse(this.responseText);
        setAuthorization(dto);
        onProfileLoad(dto);
    } else {
        onOtherResponse(profileContentDivEl, this);
    }
}