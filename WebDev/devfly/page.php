<?php
/**
 * The template for displaying all pages
 *
 * This is the template that displays all pages by default.
 * Please note that this is the WordPress construct of pages
 * and that other 'pages' on your WordPress site may use a
 * different template.
 *
 * @link https://codex.wordpress.org/Template_Hierarchy
 *
 * @package devfly
 */

get_header(); ?>
<!--banner content-->
<section id="top-banner" class="container-fluid">
  <div class="row"> 
    <!--banner content box-->
      <?php
             $bck_img  = esc_url( wp_get_attachment_url( get_post_thumbnail_id($post->ID) ));
             $link     = get_template_directory_uri();
			 $title_header = $bck_img ? "$bck_img" : $link.'/img/d-1.jpg' ;
      ?>      
    <div class="col-md-12 col-sm-12 col-xs-12 content-box nopadding text-center" style="background:url(<?php echo $title_header; ?>) rgba(0,0,0,0.5) no-repeat; background-attachment:fixed; background-size:cover;" >
      <div class="texture-overlay2"></div>
      <h1><?php the_title(); ?></h1>
      <hr>      
    </div>
    <!--/banner content box-->     
  </div>
</section>
<!--/banner content-->
<div class="clearfix"></div>
<!--About us section-->
<section class="about-us-inner-bg">
  <div class="container">
    <div class="row tab-content">      
			<?php
          if(have_posts()):
			/* Start the Loop */
			while ( have_posts() ) : the_post();?> 
        <?php the_content();?>          
          <style> .synved-social-resolution-single{display: none;} </style>         
          <?php endwhile;endif;?>
    </div>
  </div>
</section>
<?php
get_footer();