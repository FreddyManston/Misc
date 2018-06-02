<?php
/**
 * The template for displaying 404 pages (not found)
 *
 * @link https://codex.wordpress.org/Creating_an_Error_404_Page
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
			<section class="error-404 not-found">
				<header class="page-header">
					<h1 class="page-title"><?php esc_html_e( 'Oops! That page can&rsquo;t be found.', 'devfly' ); ?></h1>
				</header><!-- .page-header -->
				<div class="page-content">
					<p><?php esc_html_e( 'It looks like nothing was found at this location. Maybe try one of the links below or a search?', 'devfly' ); ?></p>
					<?php
						get_search_form();
					?>
				</div><!-- .page-content -->
			</section><!-- .error-404 -->
		</main><!-- #main -->
	</div><!-- #primary -->
   </div>
        
<aside  class="col-md-3">         
   <?php get_sidebar();?>        
</aside >
	</div>
    </div>
</section>

<?php
get_footer();
