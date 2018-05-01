function onLogoutResponse() {
    if (this.status === OK) {
        setUnauthorized();
        clearMessages();
        showContents(['login-content']);
        newInfo(loginContentDivEl, this);
    } else {
        onOtherResponse(logoutContentDivEl, this);
    }
}

function onLogoutButtonClicked() {
    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onLogoutResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'protected/logout');
    xhr.send();
}
