// =========================== Menu dropdown de usuário ===========================

function toggleDropdown(){
    let dropdown = document.querySelector('.dropdown-content')
    dropdown.classList.toggle('toggleShow')
    if(dropdown.classList.contains('toggleShow')){
        document.documentElement.onclick = function(event){
            let dropdown = document.querySelector('.dropdown-content')
            let button = document.querySelector('#user-img')
            console.log("teste")
            if (event.target != dropdown && event.target != button) {
                dropdown.classList.remove('toggleShow')
                document.documentElement.onclick = null
            }
        }
    }
    else{
        document.documentElement.onclick = null
    }
}

// =========================== Carousel da tela index ===========================

let translateValue = 0;
function carouselAction(btn){ 
    let carousel = $(btn).siblings('.carousel-card-itens').children(".carousel-slider")
    if($(btn).attr('id') === "carousel-btn-previous"){
        if(translateValue != 0){
            translateValue -= 240
            carousel.css("transform", "translateX(-"+translateValue+"px)")
        }
    }
    else{
        if(translateValue < 1440){
            translateValue += 240
            carousel.css("transform", "translateX(-"+translateValue+"px)")
        }
    }
}

// =========================== Atribuição de valor do range ===========================

function rangeInput(input){
    let value = parseFloat(input.value)

    if(value < 10)
        value = value.toFixed(1)

    $('#nota').html(value);
}

// =========================== Preview de Banner ===========================

function readURL(input) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();

        reader.onload = function (e) {
            $('#banner-image-input').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#banner-input").change(function(){
    readURL(this);
});

// =========================== Tipo da obra ===========================

$(document).ready(function() {
    if($("#combo-type").val() === "filme"){
        movieSelected()
    }
    else if($("#combo-type").val() === "serie"){
        serieSelected()
    }
    else if($("#combo-type").val() === "livro"){
        bookSelected()
    }
});

$("#combo-type").on('input', function(){
    if($("#combo-type").val() === "filme"){
        movieSelected()
    }
    else if($("#combo-type").val() === "serie"){
        serieSelected()
    }
    else if($("#combo-type").val() === "livro"){
        bookSelected()
    }
});

function movieSelected(){
		$("#director-label").css("display", "flex")
    $("#director-input").prop('required',true)

    $("#screenwriter-label").css("display", "flex")
    $("#screenwriter-input").prop('required',true)
    
    $("#production-label").css("display", "flex")
    $("#production-input").prop('required',true)


    $("#writer-label").css("display", "none")
    $("#writer-input").prop('required',false)

    $("#publisher-label").css("display", "none")
    $("#publisher-input").prop('required',false)

    $("#pages-label").css("display", "none")
    $("#pages-input").prop('required',false)

    $("#end-year-label").css("display", "none")
}

function serieSelected(){
		$("#director-label").css("display", "flex")
    $("#director-input").prop('required',true)

    $("#screenwriter-label").css("display", "flex")
    $("#screenwriter-input").prop('required',true)

    $("#production-label").css("display", "flex")
    $("#production-input").prop('required',true)

    $("#end-year-label").css("display", "flex")

    $("#writer-label").css("display", "none")
    $("#writer-input").prop('required',false)

    $("#publisher-label").css("display", "none")
    $("#publisher-input").prop('required',false)

    $("#pages-label").css("display", "none")
    $("#pages-input").prop('required',false)
}

function bookSelected(){
		$("#writer-label").css("display", "flex")
    $("#writer-input").prop('required',true)

    $("#publisher-label").css("display", "flex")
    $("#publisher-input").prop('required',true)

    $("#pages-label").css("display", "flex")
    $("#pages-input").prop('required',true)


    $("#director-label").css("display", "none")
    $("#director-input").prop('required',false)

    $("#screenwriter-label").css("display", "none")
    $("#screenwriter-input").prop('required',false)

    $("#production-label").css("display", "none")
    $("#production-input").prop('required',false)

    $("#end-year-label").css("display", "none")
}