<?php
/**
 * The main template file
 * @package devfly
 */

get_header(); ?>

<!-- Header Slider
    ==========================================-->
<section class="text-center" id="tf-home">
	<div class="carousel slide" data-ride="carousel" id="carousel-example-generic">
		<?php get_template_part( 'section-parts/section', 'ourwork' );?>
	</div>
</section>
<!-- About Us Page
    ==========================================-->
<?php if( get_theme_mod( 'themedavfly1_about_theme_check' ) == 1 ) { ?> 
<section id="tf-about" class="about-section">
  <div class="container text-center">
    <div class="row">      
      <div class="section-title ">
        <h2 class="about-title"><?php echo  $themedavfly1_title=( get_theme_mod( 'themedavfly1_about_heading' ) )?( get_theme_mod( 'themedavfly1_about_heading' ) ):'ABOUT THE THEME'; ?></h2>
        <hr>
        <p class="about-theme-desc"><?php echo  $themedavfly1_description=( get_theme_mod( 'themedavfly1_about_description' ) )?( get_theme_mod( 'themedavfly1_about_description' ) ):'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. '; ?> </p>
        <div class="clearfix"></div>
      </div> 
      <div> 
        <?php get_template_part( 'section-parts/section', 'abouttheme' );?>
      </div>
    </div>
  </div>
</section>
<?php }?>  
<!--Our Services Page
    ==========================================-->
<?php if( get_theme_mod( 'themedavfly1_service_check' ) == 1 ) { ?> 
<section id="tf-features" class="service-section">
  <div class="container">
    <div class="row">
      <?php get_template_part( 'section-parts/section', 'platform' );?>      
    </div>
  </div>
</section>
<?php }?>
<!--Portfolio Gallery
    ==========================================-->
<?php if( get_theme_mod( 'themedavfly1_Portfolio_check' ) == 1 ) { ?> 
<section id="tf-portfolio" class="portfolio-section">
  <div class="container text-center">
    <div class="section-title ">
      <h2 class="portfolio-heading"><?php echo  $themedavfly1_portfolio_heading=( get_theme_mod( 'themedavfly1_portfolio_heading' ) )?( get_theme_mod( 'themedavfly1_portfolio_heading' ) ):'see our portfolio'; ?></h2>
      <hr>
      <div class="clearfix"></div>
    </div>
    <div class="row portfolio-bg">
      <div id="fr-portfolio" class="owl-carousel owl-theme row">        
         <?php get_template_part( 'section-parts/section', 'portfolio' );?>      
       </div>  
    </div>
  </div>
</section>
<?php }?>
<!--Our Team 
    ==========================================-->
<?php if( get_theme_mod( 'themedavfly1_our_team_check' ) == 1 ) { ?> 
<section id="tf-team" class="team-section">
  <div class="container text-center">
    <div class="section-title ">
      <h2 class="our-title"><?php echo  $themedavfly1_our_team_title=( get_theme_mod( 'themedavfly1_our_team_title' ) )?( get_theme_mod( 'themedavfly1_our_team_title' ) ):'Our Team'; ?></h2>
      <hr>
      <div class="clearfix"></div>
      <p class="our-team-desc"><?php echo  $themedavfly1_title=( get_theme_mod( 'themedavfly1_team_heading' ) )?( get_theme_mod( 'themedavfly1_team_heading' ) ):'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. '; ?></p>
    </div>
    <div class="row">
      <div id="team" class="owl-carousel owl-theme row">
           <?php get_template_part( 'section-parts/section', 'ourteam' );?>  
      </div>
    </div>
  </div>
</section>
<?php }?>
<!--Choose your Plan
    ==========================================-->
<?php if( get_theme_mod( 'themedavfly1_choose_plan_check' ) == 1 ) { ?>
<section id="tf-plan" class="choose-plan">
  <div class="container text-center">
    <div class="section-title ">
      <h2 class="choose-plan-title"><?php echo  $themedavfly1_choose_plan_title=( get_theme_mod( 'themedavfly1_choose_plan_title' ) )?( get_theme_mod( 'themedavfly1_choose_plan_title' ) ):'choose your plan'; ?></h2>
      <hr>
      <div class="clearfix"></div>
      <p class="choose-urplan"><?php echo  $themedavfly1_plan_dec=( get_theme_mod( 'themedavfly1_choose_plan_dec' ) )?( get_theme_mod( 'themedavfly1_choose_plan_dec' ) ):'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. '; ?></p>
    </div>
    <div class="row"> 
        <?php get_template_part( 'section-parts/section', 'chooseplan' );?>
    </div>
  </div>
</section>
<?php }?>
<!-- Testimonials Section
    ==========================================-->
<?php if( get_theme_mod( 'themedavfly1_client_aboutus_check' ) == 1 ) { ?>
<section id="tf-testimonials" class="text-center client-about">
  <div class="container">
    <div class="section-title center">
      <h2 class="client-about-title"><?php echo  $themedavfly1_client_about_title=( get_theme_mod( 'themedavfly1_client_about_title' ) )?( get_theme_mod( 'themedavfly1_client_about_title' ) ):'clients about us'; ?></h2>
      <hr>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div id="testimonial" class="owl-carousel owl-theme"> 
          <!--item1-->
          <div class="item">               
              <?php get_template_part( 'section-parts/section', 'clientabout' );?>              
          </div>        
        </div>
      </div>
    </div>
  </div>
</section>
<?php }?>
<!-- Subscribe CTA
    ==========================================-->
<?php if( get_theme_mod( 'themedavfly1_newsletter_disable' ) == 1 ) {
        $themedavfly1_newsletter_title = get_theme_mod('themedavfly1_newsletter_title', esc_html__('SUBSCRIBE', 'devfly'));
        $themedavfly1_newsletter_mailchimp = get_theme_mod('themedavfly1_newsletter_mailchimp');
 ?> 
<section id="tf-subscribe" class="subscribe-section">
  <div class="container">
    <div class="row">
      <div class="col-md-3">      
          <?php if ($themedavfly1_newsletter_title != '') echo '<h3 class="subscribe_title">' . $themedavfly1_newsletter_title . '</h3>'; ?>          
      </div>
      <div class="col-md-9">
        <form id="searchbox" method="post" action="<?php if ($themedavfly1_newsletter_mailchimp != '') echo $themedavfly1_newsletter_mailchimp; ?>" target="_blank">
          <input type="submit" value="<?php esc_attr_e('Subscribe', 'devfly'); ?>">
          <input id="search" name="q" type="text" size="40" placeholder="<?php esc_attr_e('Enter your mail', 'devfly'); ?>" />  
        </form>
      </div>
    </div>
  </div>
</section>
<?php }?>
<!--blog Page
    ==========================================-->
<?php if( get_theme_mod( 'themedavfly1_blog_checkbox' ) == 1 ) { ?>
<section id="tf-blog" class="blog-section">
  <div class="container text-center">
    <div class="section-title ">
      <h2 class="blog-title"><?php echo  $themedavfly1_blog_title=( get_theme_mod( 'themedavfly1_blog_title' ) )?( get_theme_mod( 'themedavfly1_blog_title' ) ):'See Our Blog'; ?></h2>
      <hr>
      <div class="clearfix"></div>
      <p class="blog-desc"><?php echo  $themedavfly1_blog_desc=( get_theme_mod( 'themedavfly1_blog_desciption' ) )?( get_theme_mod( 'themedavfly1_blog_desciption' ) ):'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. '; ?>
      </p>
    </div>
    <div class="row">
      <div id="blogarticle-id" class="owl-carousel owl-theme"> 
      <?php
        if(have_posts()!='')
        {
        while ( have_posts() ) :  the_post(); ?>         
			<div class="item">
          <!--blog-box-->
			  <div class="col-md-12">
				<article> <?php the_post_thumbnail('themedavfly1_recent_post'); ?>
				  <div class="article-content">
					<a href="<?php the_permalink();?>"><h2><?php $words_title=get_the_title(); echo $words_title; ?></h2></a>
					<p><?php $content=get_the_content();
				 echo  $trimmed = wp_trim_words( $content, $num_words = 15, $more = null ); ?></p>
					<header class="entry-header"> <span class="byline"><span class="author vcard"> <?php echo get_avatar( get_the_author_meta('ID'), 40); ?><a href="#"><?php get_the_author_meta('display_name');?></a></span></span><span class="date-article"><?php echo get_the_date('M d, Y'); ?></span> </header>
					<a class="btn btn-default text-center" href="<?php the_permalink();?>">Read More</a> </div>
				</article>
			  </div>
			  <!--/blog-box--> 
			</div>
        <?php endwhile;}else{?>
				<div class="item">
					<!--blog-box-->
				  <div class="col-md-12">
					<article> <img src="<?php echo get_template_directory_uri();?>/img/d-3.jpg" class="img-responsive">
					  <div class="article-content">
						<h2>Change the life around</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. </p>
						<header class="entry-header"> <span class="byline"><span class="author vcard"><img src="<?php echo get_template_directory_uri();?>/img/team/03.jpg" width="40" class="img-circle avatar" alt=""><a href="#">Jinny susan</a></span></span><span class="date-article">Jan 27</span> </header>
						<a class="btn btn-default text-center" href="#">read more</a> </div>
					</article>
				  </div>
				</div>
					<!--/blog-box--> 
           <div class="item">
          <!--blog-box-->
          <div class="col-md-4">
            <article> <img src="<?php echo get_template_directory_uri();?>/img/t-5.jpg" class="img-responsive">
              <div class="article-content">
                <h2>The way you live </h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. </p>
                <header class="entry-header"> <span class="byline"><span class="author vcard"><img src="<?php echo get_template_directory_uri();?>/img/team/03.jpg" width="40" class="img-circle avatar" alt=""><a href="#">Jinny susan</a></span></span><span class="date-article">Jan 27</span> </header>
                <a class="btn btn-default text-center" href="#">read more</a> </div>
            </article>
          </div>
          </div>
            <?php }?>
          <!--/blog-box--> 
        <!--/item1-->        
      </div>
    </div>
  </div>
</section>
<?php }?>
<?php
get_footer();