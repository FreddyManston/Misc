<?php
/**
 * The template for displaying all single posts
 *
 * @link https://developer.wordpress.org/themes/basics/template-hierarchy/#single-post
 *
 * @package main_multi_theme(davfly1)
 */

get_header(); ?>

<section id="top-banner" class="container-fluid">
  <div class="row"> 
    <!--banner content box-->      
       <?php if(have_posts() ) : while(have_posts() ) : the_post();      
       $devfly_featured_img_url = wp_get_attachment_url(get_post_thumbnail_id(get_the_id())); 
      ?>     
    <div class="col-md-12 col-sm-12 col-xs-12 content-box nopadding text-center" style="background:url(<?php echo esc_url($devfly_featured_img_url); ?>) rgba(0,0,0,0.5) no-repeat; background-attachment:fixed; background-size:cover;" >
      <div class="texture-overlay2"></div>
      <h1><?php the_title(); ?></h1>
    </div>
    <!--/banner content box-->     
      <?php endwhile;endif;?>
  </div>
</section>
<!--/banner content-->

<div class="clearfix"></div>
<section id="If-single-inn">
  <div class="container">
    <div class="row">      
      <!--=================Article section-->
      <div class="col-md-9 col-sm-8 blog-art  single-articl">
          
        <?php if(have_posts() ) : while(have_posts() ) : the_post(); ?>
          
        <header class="entry-header text-center"> <span class="posted-on">Posted on <a href="<?php the_permalink();?>">
          <time ><?php the_date('F j, Y');?></time>
          </a> </span> <span class="byline"><span class="author vcard"> <?php echo get_avatar( get_the_author_meta('ID'), 40); ?><a href="#"><?php get_the_author_meta('display_name');?></a></span></span> </header>
        	   <hr>
        <p>        
             <?php 
                     $content1 = strip_shortcode_gallery( the_content() );       
            ?>          
        </p> 
		<?php esc_html_e('Category : ','edge');  the_category(', '); ?>
		<?php $tag_list = get_the_tag_list( '', __( ', ', 'edge' ) ); ?>
		<?php   echo $tag_list; ?>
          <?php endwhile;endif;?>
        <!--comments-->
        <div id="comments" class="comments-area text-left">
          <h2 class="comments-title"> Comments </h2>
            <?php comments_template();?>          
        </div>        
        <!--/comments-->         
      </div>
      <!--=================/Article section--> 
      
      <!--=================Aside section-->
		<aside  class="col-md-3">         
          <?php get_sidebar(); ?>
		</aside >
      <!--=================/Aside section--> 
    </div>
  </div>
</section>
<!--footer Section-->
<?php
get_footer();
