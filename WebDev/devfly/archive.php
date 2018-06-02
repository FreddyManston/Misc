<?php
/**
 * The template for displaying archive pages
 *
 * @link https://codex.wordpress.org/Template_Hierarchy
 *
 * @package devfly
 */

get_header(); ?>
<section id="If-blog-inn">
  <div class="container ">
    <div class="row">       
      <!--=================blog section-->
      <div class="col-md-9 col-sm-8 blog-art  single-articl text-center"> 
          <div id="primary" class="content-area">
		<main id="main" class="site-main" role="main">
		<?php
		if ( have_posts() ) : ?>
			<header class="page-header">
				<?php
					the_archive_title( '<h1 class="page-title">', '</h1>' );
					the_archive_description( '<div class="archive-description">', '</div>' );
				?>
			</header><!-- .page-header -->
			<?php
			/* Start the Loop */
			while ( have_posts() ) : the_post();?>
           <div class="col-md-6 blog-article-box">
          <article> 
              <?php the_post_thumbnail('themedavfly1_recent_post'); ?>
              <!--<img src="img/t-1.jpg" class="img-responsive">-->
            <div class="article-content">
              <h2><?php  $words_titl=get_the_title();
                        echo  $words = wp_trim_words( $words_titl, $num_words = 5, $more = null ); ?></h2>
              <p><?php $content=get_the_content();
             echo  $trimmed = wp_trim_words( $content, $num_words = 15, $more = null ); ?></p>
              <header class="entry-header"> <span class="byline"><span class="author vcard"><?php echo get_avatar( get_the_author_meta('ID'), 40); ?><a href="#"><?php echo get_the_author_meta('display_name');?></a></span></span><span class="date-article"><?php echo get_the_date(); ?></span> </header>
              <a class="btn btn-default text-center" href="<?php the_permalink();?>">read more</a> </div>
          </article>
        </div>
            <?php 
			endwhile;

			the_posts_navigation();

		

		endif; ?>

		</main><!-- #main -->
	</div><!-- #primary -->
          
          
             
      </div>
      <!--=================/blog section--> 
      
      <!--=================Aside section-->
      <aside  class="col-md-3"> 
        
        <?php get_sidebar();?>
        
        
      </aside >
      <!--=================/Aside section--> 
      
    </div>
  </div>
</section>



<?php

get_footer();
