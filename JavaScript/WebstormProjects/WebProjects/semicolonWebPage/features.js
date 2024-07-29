//RESPONSIVE STYLING FOR HEADER //


window.addEventListener('resize', (adjustNavItems) => {
    const navItems = document.querySelector(".list-container");
    if(window.outerWidth < 1275){
        // navItems.style.border = '2px solid red';
        navItems.style.width = '100%';
    } else {
        // navItems.style.border = 'none';
        navItems.style.width = '60%';
    }
})
window.addEventListener('resize', (hideMainNavItems) => {
    const mainNav = document.querySelector(".list-container");
    const hamburgerContainer = document.querySelector(".hamburger");
    const hamburgerBtn = document.querySelector(".hamburgerBtn");
    if(window.outerWidth < 1077){
        mainNav.style.display = 'none';
        hamburgerContainer.style.display = 'block'
    } else {
        mainNav.style.display = 'flex';
        hamburgerContainer.style.display = 'none'
    }
});
window.addEventListener('resize', (hamburgerBtnStyles) => {
    const hamburgerBtn = document.querySelector(".hamburgerBtn");
    const hamburgerContainer = document.querySelector(".hamburger");
    hamburgerBtn.style.backgroundColor = 'white';
    hamburgerContainer.style.border = 'none'
    hamburgerContainer.style.width = '100px'
    hamburgerBtn.style.display = 'block';
    hamburgerBtn.style.border = 'none';
    hamburgerBtn.style.cursor = 'pointer';
});
function displaySideNavBar(){
    const hamburgerBtnId = document.getElementById("hamburgerBtn");
    const hamburgerBtn = document.querySelector(".hamburgerBtn");
    const sideBarNav = document.querySelector(".side-bar");
    hamburgerBtn.style.display = 'none';
    sideBarNav.style.display = 'flex';
    sideBarNav.style.flexDirection = 'column';
}
function hideSideBarNav(){
    const hamburgerBtnId = document.getElementById("hamburgerBtn");
    const hamburgerBtn = document.querySelector(".hamburgerBtn");
    const sideBarNav = document.querySelector(".side-bar");
    hamburgerBtn.style.display = 'block';
    sideBarNav.style.display = 'none';
}
window.addEventListener('resize', (hideSideBarNav) => {
    const sideBarNav = document.querySelector(".side-bar");
    if (window.outerWidth > 1000){
        sideBarNav.style.display = 'none';
    }
})

//RESPONSIVE STYLING FOR SECTION-1 //

window.addEventListener('resize', (stylingAdjustmentsForSectionOne) =>{
    const section_1 = document.querySelector(".section-1");
    const leftHemisphere = document.querySelector(".left-hemisphere");
    const header = document.querySelector(".header");
    const section1_leftHemisphere_bodyOfText = document.querySelector(".bodyOfText");
    const rightHemisphere = document.querySelector(".right-hemisphere");
    const containerForButtons = document.querySelector(".containerForButtons");
    if (window.outerWidth < 800){
        section_1.style.display = 'block';
        section_1.style.width = '100%';
        leftHemisphere.style.margin = 'auto';
        leftHemisphere.style.width = '60%';
        header.style.textAlign = 'center';
        rightHemisphere.style.display = 'none';
        section1_leftHemisphere_bodyOfText.style.width = '100%';
        section1_leftHemisphere_bodyOfText.style.textAlign = 'center';
        containerForButtons.style.gap = '30px';
        containerForButtons.style.width = '100%';
        containerForButtons.style.justifyContent = 'space-around'
    } else {
        section_1.style.border = 'none';
        section_1.style.width = '100%';
        section_1.style.height = '35rem';
        section_1.style.display = 'flex';
        section_1.style.justifyContent = 'space-evenly';
        leftHemisphere.style.width = '45%';
        leftHemisphere.style.margin = '0';
        leftHemisphere.style.border = 'none';
        rightHemisphere.style.border = 'none';
        rightHemisphere.style.display = 'block';
        header.style.textAlign = 'left';
        section1_leftHemisphere_bodyOfText.style.width = '85%';
        section1_leftHemisphere_bodyOfText.style.textAlign = 'left';
        containerForButtons.style.display = 'flex'
        containerForButtons.style.justifyContent = 'flex-start'
        containerForButtons.style.width = '80%';
        containerForButtons.style.border = 'none';
    }
});
window.addEventListener('resize', (adjustRightHemisphereAt1077) => {
    const section1_rightHemisphere = document.querySelector(".right-hemisphere");
    const globeImg = document.querySelector(".globeImg");
    if(window.outerWidth < 1077){
        // section1_rightHemisphere.style.border = '2px solid black';
        // globeImg.style.border = '2px solid red';
        globeImg.style.marginTop = '60px'
    } else {
        section1_rightHemisphere.style.border = 'none';
        globeImg.style.marginTop = '0';
    }
});

//RESPONSIVE STYLING FOR SECTION 2

window.addEventListener('resize', (adjustSection2WhenWindowIsLessThan1410px) => {
    let section_2 = document.querySelector(".section-2");
    let contentContainer = document.querySelector(".contentContainer");
    let header_Txt2Container = document.querySelector(".header-Txt2Container");
    let hero_headerTXT = document.querySelector(".hero-headerTXT");
    let blockContainers = document.querySelector(".blockContainers");
    let leftBlock = document.querySelector(".leftBlock");
    let circleShapeIcon = document.querySelector(".circleShapeIcon");
    let bodyTxtOfLeftBlock = document.querySelector(".bodyTxtOfLeftBlock");
    let rightBlock = document.querySelector(".section-2");
    let bodyTxtOfRightBlock = document.querySelector(".bodyTxtOfRightBlock");
    let squareShapeIcon = document.querySelector(".squareShapeIcon");


    if(window.outerWidth  < 1410){
        section_2.style.border = '2px solid black';
    } else {
        section_2.style.border = 'none';
    }

});

window.addEventListener('resize', (addBorderToContentContainer) => {
    let contentContainer = document.querySelector(".contentContainer");
    let leftBlock = document.querySelector(".leftBlock");
    let circleShapeIcon = document.querySelector(".circleShapeIcon");
    let rightBlock = document.querySelector(".rightBlock");
    let squareShapeIcon = document.querySelector(".squareShapeIcon");

    if (window.outerWidth < 1410){
        contentContainer.style.border = '2px solid black';
        circleShapeIcon.style.border = '2px solid black';
        leftBlock.style.border = '2px solid black';
        rightBlock.style.border = '2px solid black';
        squareShapeIcon.style.border = '2px solid black'
        leftBlock.style.padding = '30px 41px';
        rightBlock.style.padding = '30px 41px';
    } else {
        contentContainer.style.border = 'none';
        circleShapeIcon.style.border = 'none';
        squareShapeIcon.style.border = 'none';
        rightBlock.style.border = 'none';
        leftBlock.style.border = 'none';
        leftBlock.style.padding = '65px 51px';
        rightBlock.style.padding = '65px 51px';

    }
});
window.addEventListener('resize', (addBorderToContentContainer) => {
    let contentContainer = document.querySelector(".contentContainer");
    let leftBlock = document.querySelector(".leftBlock");
    let circleShapeIcon = document.querySelector(".circleShapeIcon");
    let rightBlock = document.querySelector(".rightBlock");
    let squareShapeIcon = document.querySelector(".squareShapeIcon");

    if (window.outerWidth < 900){
        leftBlock.style.border = '2px solid black';
        // leftBlock.style.width = '80%';
        // leftBlock.style.height = '60%';
        rightBlock.style.border = '2px solid black';
        squareShapeIcon.style.border = '2px solid black';
        leftBlock.style.padding = '30px 41px';
        rightBlock.style.padding = '30px 41px';
    } else {
        squareShapeIcon.style.border = 'none';
        rightBlock.style.border = 'none';
        leftBlock.style.border = 'none';
        leftBlock.style.padding = '65px 51px';
        rightBlock.style.padding = '65px 51px';
        // leftBlock.style.width = '47%';
        // leftBlock.style.height = '80%';

    }
});


