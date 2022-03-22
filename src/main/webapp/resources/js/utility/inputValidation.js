function validateName(name) {

    let pattern = /^[A-Za-z ]+$/;
    if (name !== null && name !== "" && name !== " " && pattern.test(name)) {
        return true;
    } else {
        return false;
    }
}


function validateEmail(email) {
    /* Regular expression pattern to check email is valid or not */
    let pattern = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if (email !== null && email !== "" && email !== " " && pattern.test(email)) {
        return true;
    } else {
        return false;
    }
}


function validateUsername(uname) {
    if (uname !== null && uname !== "" && uname !== " ") {
        return true;
    } else {
        return false;
    }
}

function validateMobile(mobile) {

    let pattern = /^\d{10}$/;
    if (mobile !== null && pattern.test(mobile)) {
        return true;
    } else {
        return false;
    }
}


function validateBirthdate(dob) {
    /* Regular expression pattern to check if birth date is in format yyyy/mm/dd */
    let pattern = /^[0-9]{4}\-(1[0-2]|0[1-9])\-(3[01]|[12][0-9]|0[1-9])$/;
    if (dob !== null && dob !== "" && dob !== " " && pattern.test(dob)) {
        return true;
    } else {
        return false;
    }
}


function validatePassword(password) {
    let pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
    if (password !== null && pattern.test(password)) {
        return true;
    } else {
        return false;
    }
}

function validateAddress(address) {
    if (address !== null && address !== "" && address !== " ") {
        return true;
    } else {
        return false;
    }
}


function validateUsertype(userType) {
    /* userType should be either buyer or seller */
    const types = ["0", "1"];
    if (userType !== null && userType !== "" && userType !== " "
        && types.includes(userType)) {
        return true;
    } else {
        return false;
    }
}


function validateWalletAmount(amount) {

    let pattern = /^\d+(\.\d{1,3})?$/;
    if (amount !== null && amount !== "" && amount !== " "
        && pattern.test(amount)) {
        return true;
    } else {
        return false;
    }
}


function validateLoginPassword(loginPassword) {
    if (loginPassword !== null && loginPassword !== "" && loginPassword !== " ") {
        return true;
    } else {
        return false;
    }
}

function validateProductName(productName) {
    if (productName !== null && productName !== "" && productName !== " ") {
        return true;
    } else {
        return false;
    }
}


function validateProductDescription(productDesp) {
    if (productDesp !== null && productDesp !== "" && productDesp !== " ") {
        return true;
    } else {
        return false;
    }
}


function validateActualPrice(actualPrice) {

    let pattern = /^\d+(\.\d{1,3})?$/;
    if (actualPrice !== null && actualPrice !== "" && actualPrice !== " "
        && pattern.test(actualPrice)) {
        return true;
    } else {
        return false;
    }
}


function validateProductQuantity(productQuantity) {

    let pattern = /^[0-9]*$/;
    if (productQuantity !== null && productQuantity !== "" && productQuantity !== " "
        && pattern.test(productQuantity)) {
        return true;
    } else {
        return false;
    }
}


function validateUploadImage() {
    let imageInput = document.getElementById('img');
    let imagePath = imageInput.value;

    let imgExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;

    if (!imgExtensions.exec(imagePath)) {
        imageInput.value = '';
        return false;
    } else {
        // Image preview
        /*
        if (imageInput.files && imageInput.img[0]) {
            let reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('imagePreview').innerHTML = '<img src="'
                        + e.target.result + '"/>';
            };

            reader.readAsDataURL(imageInput.img[0]);
        }*/
        return true;
    }
}

/*
 * validateMinimumBidValue function is check if minimumBidValue is not null or empty. If minimumBidValue
 * is valid then return true else false
 */
function validateMinimumBidValue(minimumBidValue) {
    /*
     * Regular expression pattern to check if minimumBidValue is digit
     */
    let pattern = /^[0-9]*$/;
    if (minimumBidValue !== null && minimumBidValue !== "" && minimumBidValue !== " " && pattern.test(minimumBidValue)) {
        return true;
    } else {
        return false;
    }
}


/*
 * validateDate function is check if start date is not null or empty and
 * test with given regex pattern. If start & end Date are valid then return true else
 * false
 */
function validateDate(scheduleDate) {
    /* Regular expression pattern to check if birth date is in format yyyy/mm/dd */
    let pattern = /^[0-9]{4}\-(1[0-2]|0[1-9])\-(3[01]|[12][0-9]|0[1-9])$/;
    if (scheduleDate !== null && scheduleDate !== "" && scheduleDate !== " " && pattern.test(scheduleDate)) {
        return true;
    } else {
        return false;
    }
}