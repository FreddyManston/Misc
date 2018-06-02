<?php
/**
 * The template for displaying search results pages
 *
 * @link https://developer.wordpress.org/themes/basics/template-hierarchy/#search-result
 *
 * @package devfly
 */

get_header(); ?>

<section id="If-blog-inn">
  <div class="container ">
    <div class="row">       
      <!--=================blog section-->
      <div class="col-md-9 col-sm-8 blog-art  single-articl text-center"> 
	<section id="primary" class="content-area">
		<main id="main" class="site-main" role="main">
		<?php
		if ( have_posts() ) : ?>
			<header class="page-header">
				<h1 class="page-title"><?php printf( esc_html__( 'Search Results for: %s', 'devfly' ), '<span>' . get_search_query() . '</span>' ); ?></h1>
			</header><!-- .page-header -->
			<?php
			/* Start the Loop */
			while ( have_posts() ) : the_post();
				/**
				 * Run the loop for the search to output the results.
				 * If you want to overload this in a child theme then include a file
				 * called content-search.php and that will be used instead.
				 */			
            ?>
        <!--Blog box-->
        <div class="col-md-6 blog-article-box">
          <article> 
              <?php the_post_thumbnail('themedavfly1_recent_post'); ?>
            <div class="article-content">
              <h2><?php  $words_titl=get_the_title();
                        echo  $words = wp_trim_words( $words_titl, $num_words = 5, $more = null ); ?></h2>
              <p><?php $content=get_the_content();
             echo  $trimmed = wp_trim_words( $content, $num_words = 15, $more = null ); ?></p>
              <header class="entry-header"> <span class="byline"><span class="author vcard"><?php echo get_avatar( get_the_author_meta('ID'), 40); ?><a href="#"><?php echo get_the_author_meta('display_name');?></a></span></span><span class="date-article"><?php echo get_the_date(); ?></span> </header>
              <a class="btn btn-default text-center" href="<?php the_permalink();?>">read more</a> </div>
          </article>
        </div>
        <!--/Blog box-->           
      <?php
			endwhile;
			the_posts_navigation();
		else :
			get_template_part( 'template-parts/content', 'none' );
		endif; ?>
		</main><!-- #main -->
	</section><!-- #primary -->
  </div>        
	<aside  class="col-md-3">         
		<?php get_sidebar();?>        
	</aside>          
 </div>
</div>
</section>
<?php
get_sidebar();
get_footer();
