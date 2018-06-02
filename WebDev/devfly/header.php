<?php
/**
 * The header for our theme
 */
?>
<!DOCTYPE html>
<html <?php language_attributes(); ?>>
<head>
<!-- Basic Page Needs
    ================================================== -->
<meta charset="<?php bloginfo( 'charset' ); ?>">
<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<?php wp_head(); ?>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body <?php body_class(); ?>>
<!-- Navigation
    ==========================================-->
<nav id="tf-menu" class="navbar navbar-default navbar-fixed-top">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand site-title" href="<?php echo esc_url( home_url( '/' ) ); ?>">
            <?php  
             $logo    = esc_url( get_theme_mod( 'logo' ) );
             $link    = get_template_directory_uri();
			 $title_header = $logo ? "<img  src='$logo' class='img-responsive' width='36' >" : "<img src='$link/img/logo.png' class='img-responsive' width='36' >" ;                             
     ?>
        <?php if($logo) { echo $title_header;} else {bloginfo( 'name' );}  ?>  </a>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	    <?php
						wp_nav_menu( array(
							'theme_location'  => 'menu-1',
							'container' => 'ul',
							'menu_class' => 'nav navbar-nav ',
							'menu_id'   => 'nav-menu',
						) );
		?>
       </div>
    <!-- /.navbar-collapse --> 
  </div>
  <!-- /.container-fluid --> 
</nav>

