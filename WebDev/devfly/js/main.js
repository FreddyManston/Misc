// Hello.
//
// This is The Scripts used for ___________ Theme
//
//

function main() {

(function () {
   'use strict';

   /* ==============================================
  	Testimonial Slider
  	=============================================== */ 

  	$('a.page-scroll').click(function() {
        if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
          var target = $(this.hash);
          target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
          if (target.length) {
            $('html,body').animate({
              scrollTop: target.offset().top - 40
            }, 900);
            return false;
          }
        }
      });

    /*====================================
    Show Menu on Book
    ======================================*/
    $(window).bind('scroll', function() {
        var navHeight = $(window).height() - 100;
        if ($(window).scrollTop() > navHeight) {
            $('.navbar-default').addClass('on');
        } else {
            $('.navbar-default').removeClass('on');
        }
    });

    $('body').scrollspy({ 
        target: '.navbar-default',
        offset: 80
    })

  	$(document).ready(function() {
  	  $("#fr-portfolio").owlCarousel({
  	 
  	      navigation : false, // Show next and prev buttons
  	      slideSpeed : 300,
  	      paginationSpeed : 400,
  	      autoHeight : true,
  	    singleItem:true
  	  });
	  
	  
	    	  $("#team").owlCarousel({
  	 
  	      navigation : false, // Show next and prev buttons
  	      slideSpeed : 300,
  	      paginationSpeed : 400,
  	      autoHeight : true,
  	      itemsCustom : [
				        [0, 1],
				        [450, 2],
				        [600, 2],
				        [700, 2],
				        [1000, 3],
				        [1200, 3],
				        [1400, 3],
				        [1600, 3]
				      ],
  	  });
	  
	  
	    $("#ab-content").owlCarousel({
  	 
  	      navigation : false, // Show next and prev buttons
  	      slideSpeed : 300,
  	      paginationSpeed : 400,
  	      autoHeight : true,
  	    singleItem:true
  	  });
	  
	  
	  
	     $("#fr-content").owlCarousel({
  	 
  	      navigation : false, // Show next and prev buttons
  	      slideSpeed : 300,
  	      paginationSpeed : 400,
  	      autoHeight : true,
  	    singleItem:true
  	  });
	  
	  
	     $("#de-content").owlCarousel({
  	 
  	      navigation : false, // Show next and prev buttons
  	      slideSpeed : 300,
  	      paginationSpeed : 400,
  	      autoHeight : true,
  	    singleItem:true
  	  });
	  
	  
	  

  	  $("#clients").owlCarousel({
  	 
  	      navigation : false, // Show next and prev buttons
  	      slideSpeed : 300,
  	      paginationSpeed : 400,
  	      autoHeight : true,
  	      itemsCustom : [
				        [0, 1],
				        [450, 2],
				        [600, 2],
				        [700, 2],
				        [1000, 4],
				        [1200, 5],
				        [1400, 5],
				        [1600, 5]
				      ],
  	  });

      $("#testimonial").owlCarousel({
        navigation : false, // Show next and prev buttons
        slideSpeed : 300,
        paginationSpeed : 400,
        singleItem:true
        });


  $("#blogarticle-id").owlCarousel({
        navigation : false, // Show next and prev buttons
        slideSpeed : 300,
        paginationSpeed : 400,
             singleItem:false,
      itemsCustom : [
				        [0, 1],
				        [450, 2],
				        [600, 2],
				        [700, 2],
				        [1000, 3],
				        [1200, 3],
				        [1400, 3],
				        [1600, 3]
				      ],
      
        });

  	});
	
	
	

  	/*====================================
    Portfolio Isotope Filter
    ======================================*/
    $(window).load(function() {
        var $container = $('#lightbox');
        $container.isotope({
            filter: '*',
            animationOptions: {
                duration: 750,
                easing: 'linear',
                queue: false
            }
        });
        $('.cat a').click(function() {
            $('.cat .active').removeClass('active');
            $(this).addClass('active');
            var selector = $(this).attr('data-filter');
            $container.isotope({
                filter: selector,
                animationOptions: {
                    duration: 750,
                    easing: 'linear',
                    queue: false
                }
            });
            return false;
        });

    });

$(document).ready(function(){$(".wp1").waypoint(function(){$(".wp1").addClass("animated fadeInLeft")},{offset:"75%"});$(".wp2").waypoint(function(){$(".wp2").addClass("animated fadeInDown")},{offset:"75%"});$(".wp3").waypoint(function(){$(".wp3").addClass("animated bounceInDown")},{offset:"75%"});$(".wp4").waypoint(function(){$(".wp4").addClass("animated fadeInDown")},{offset:"75%"});$("#featuresSlider").flickity({cellAlign:"left",contain:true,prevNextButtons:false});$("#showcaseSlider").flickity({cellAlign:"left",contain:true,prevNextButtons:false,imagesLoaded:true});$(".youtube-media").on("click",function(e){var t=$(window).width();if(t<=768){return}$.fancybox({href:this.href,padding:4,type:"iframe",href:this.href.replace(new RegExp("watch\\?v=","i"),"v/")});return false})});$(document).ready(function(){$("a.single_image").fancybox({padding:4})});$(".nav-toggle").click(function(){$(this).toggleClass("active");$(".overlay-boxify").toggleClass("open")});$(".overlay ul li a").click(function(){$(".nav-toggle").toggleClass("active");$(".overlay-boxify").toggleClass("open")});$(".overlay").click(function(){$(".nav-toggle").toggleClass("active");$(".overlay-boxify").toggleClass("open")});$("").click(function(){if(location.pathname.replace(/^\//,"")===this.pathname.replace(/^\//,"")&&location.hostname===this.hostname){var e=$(this.hash);e=e.length?e:$("[name="+this.hash.slice(1)+"]");if(e.length){$("html,body").animate({scrollTop:e.offset().top},2e3);return false}}})

}());


    
    
}
main();