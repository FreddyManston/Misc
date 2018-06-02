/**
 * File customizer.js.
 *
 * Theme Customizer enhancements for a better user experience.
 *
 * Contains handlers to make Theme Customizer preview reload changes asynchronously.
 */

( function( $ ) {

	// Site title and description.
	wp.customize( 'blogname', function( value ) {
		value.bind( function( to ) {
			$( '.site-title a' ).text( to );
		} );
	} );
	wp.customize( 'blogdescription', function( value ) {
		value.bind( function( to ) {
			$( '.site-description' ).text( to );
		} );
	} );

    wp.customize( 'name', function( value ) {
		value.bind( function( to ) {
			$( '.navbar-brand' ).text( to );
		} );
	} );
    
	// Header text color.
	wp.customize( 'header_textcolor', function( value ) {
		value.bind( function( to ) {
			if ( 'blank' === to ) {
				$( '.site-title a, .site-description' ).css( {
					'clip': 'rect(1px, 1px, 1px, 1px)',
					'position': 'absolute'
				} );
			} else {
				$( '.site-title a, .site-description' ).css( {
					'clip': 'auto',
					'position': 'relative'
				} );
				$( '.site-title a, .site-description' ).css( {
					'color': to
				} );
			}
		} );
	} );

    /*logo in header section*/
     wp.customize( 'logo', function( value ) {
		value.bind( function( to ) {
			$( '.fnav .logo-img img' ).text( to );
		} );
	} );
    
    
    
    //about section page
    
     wp.customize( 'themedavfly1_about_theme_check', function( value ) {
			value.bind( function( to ) {
            if ( true === to) {
            $( '.about-section' ).show();
            } 
            else {
            $( '.about-section' ).hide();
            } 
			} );
		} ); 
    
    /*about heading*/
     wp.customize( 'themedavfly1_about_heading', function( value ) {
		value.bind( function( to ) {
			$( '.about-title' ).text( to );
		} );
	} );
    
     /*about description*/
     wp.customize( 'themedavfly1_about_description', function( value ) {
		value.bind( function( to ) {
			$( '.section-title .about-theme-desc' ).text( to );
		} );
	} );
    
    
    
    /*about description*/
     wp.customize( 'themedavfly1_about_description', function( value ) {
		value.bind( function( to ) {
			$( '.section-title .about-theme-desc' ).text( to );
		} );
	} );
    
    /*Service Section*/
    
      wp.customize( 'themedavfly1_service_check', function( value ) {
			value.bind( function( to ) {
            if ( true === to) {
            $( '.service-section' ).hide();
            } 
            else {
            $( '.service-section' ).show();
            } 
			} );
		} ); 
    
    /*portfolio Section*/
    
      wp.customize( 'themedavfly1_Portfolio_check', function( value ) {
			value.bind( function( to ) {
            if ( true === to) {
            $( '.portfolio-section' ).show();
            } 
            else {
            $( '.portfolio-section' ).hide();
            } 
			} );
		} ); 
    
      wp.customize( 'themedavfly1_portfolio_heading', function( value ) {
		value.bind( function( to ) {
			$( '.portfolio-heading' ).text( to );
		} );
	} );
    
    
    
    /*Our team*/
    
    wp.customize( 'themedavfly1_our_team_check', function( value ) {
			value.bind( function( to ) {
            if ( true === to) {
            $( '.team-section' ).show();
            } 
            else {
            $( '.team-section' ).hide();
            } 
			} );
		} ); 
    
      wp.customize( 'themedavfly1_our_team_title', function( value ) {
		value.bind( function( to ) {
			$( '.our-title' ).text( to );
		} );
	} );
    
    
    
     wp.customize( 'themedavfly1_team_heading', function( value ) {
		value.bind( function( to ) {
			$( '.our-team-desc' ).text( to );
		} );
	} );
    
    /*choose plan*/
    
    
    wp.customize( 'themedavfly1_choose_plan_check', function( value ) {
			value.bind( function( to ) {
            if ( true === to) {
            $( '.choose-plan' ).show();
            } 
            else {
            $( '.choose-plan' ).hide();
            } 
			} );
		} ); 
    
      wp.customize( 'themedavfly1_choose_plan_title', function( value ) {
		value.bind( function( to ) {
			$( '.choose-plan-title' ).text( to );
		} );
	} );
    
    
     wp.customize( 'themedavfly1_choose_plan_dec', function( value ) {
		value.bind( function( to ) {
			$( '.choose-urplan' ).text( to );
		} );
	} );
    
    
     /*Clent About*/
    
    wp.customize( 'themedavfly1_client_aboutus_check', function( value ) {
			value.bind( function( to ) {
            if ( true === to) {
            $( '.client-about' ).show();
            } 
            else {
            $( '.client-about' ).hide();
            } 
			} );
		} ); 
    
      wp.customize( 'themedavfly1_client_about_title', function( value ) {
		value.bind( function( to ) {
			$( '.client-about-title' ).text( to );
		} );
	} );
    
    
     
    
    /*Our blog*/
        
     wp.customize( 'themedavfly1_blog_checkbox', function( value ) {
			value.bind( function( to ) {
            if ( true === to) {
            $( '.blog-section' ).show();
            } 
            else {
            $( '.blog-section' ).hide();
            } 
			} );
		} ); 
    
      wp.customize( 'themedavfly1_blog_title', function( value ) {
		value.bind( function( to ) {
			$( '.blog-title' ).text( to );
		} );
	} );
    
       wp.customize( 'themedavfly1_blog_desciption', function( value ) {
		value.bind( function( to ) {
			$( '.blog-desc' ).text( to );
		} );
	} );
    
    
     wp.customize( 'themedavfly1_blog_page_image', function( value ) {
		value.bind( function( to ) {
			$( '.nopadding' ).text( to );
		} );
	} );
    
    wp.customize( 'themedavfly1_blog_page_title_first', function( value ) {
		value.bind( function( to ) {
			$( '.title-blog-page' ).text( to );
		} );
	} );
    
     wp.customize( 'themedavfly1_blog_page_title_second', function( value ) {
		value.bind( function( to ) {
			$( '.second-title-blogpage' ).text( to );
		} );
	} );
    
      /*subscribe*/
     wp.customize( 'themedavfly1_newsletter_disable', function( value ) {
		value.bind( function( to ) {
			$( '.subscribe-section' ).text( to );
		} );
	} );
    
    wp.customize( 'themedavfly1_newsletter_title', function( value ) {
		value.bind( function( to ) {
			$( '.subscribe_title' ).text( to );
		} );
	} );
    
    
     /*footer_desc*/
     wp.customize( 'themedavfly1_footer_dec', function( value ) {
		value.bind( function( to ) {
			$( '.logo-img p' ).text( to );
		} );
	} );
    
    /*footer contact*/
     wp.customize( 'themedavfly1_contact_us', function( value ) {
		value.bind( function( to ) {
			$( '.address-footer-section' ).text( to );
		} );
	} );
    
    /*footer contact mail*/
     wp.customize( 'themedavfly1_contact_mail', function( value ) {
		value.bind( function( to ) {
			$( '.contact-mail' ).text( to );
		} );
	} );
    
    /*footer subscribe*/
    
    wp.customize( 'themedavfly1_footer_subscribe', function( value ) {
			value.bind( function( to ) {
            if ( true === to) {
            $( '.subscribe-footer' ).show();
            } 
            else {
            $( '.subscribe-footer' ).hide();
            } 
			} );
		} ); 
    
    /*footer devepled by*/
     wp.customize( 'themedavfly1_developed_by', function( value ) {
		value.bind( function( to ) {
			$( '.copyright span' ).text( to );
		} );
	} );
    
} )( jQuery );
