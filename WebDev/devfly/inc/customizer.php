<?php
/**
 * devfly Theme Customizer
 *
 * @package devfly
 */

/**
 * Add postMessage support for site title and description for the Theme Customizer.
 *
 * @param WP_Customize_Manager $wp_customize Theme Customizer object.
 */
function main_multi_themedavfly1_customize_register( $wp_customize ) {
    
     require get_template_directory() . '/inc/customizer-controls.php';
    
	$wp_customize->get_setting( 'blogname' )->transport         = 'refresh';
	$wp_customize->get_setting( 'blogdescription' )->transport  = 'postMessage';
	$wp_customize->get_setting( 'header_textcolor' )->transport = 'postMessage';
	$wp_customize->remove_section('header_image');
	$wp_customize->remove_section('background_image');
	$wp_customize->remove_setting('display_header_text');
	
    
     /* $wp_customize->remove_control('header_text');*/
    
    
     $wp_customize->add_setting( 'logo', array(
			'default'           => '',
			'type'              => 'theme_mod',
			'capability'        => 'edit_theme_options',
			'sanitize_callback' => 'devfly_main_sanitize_url_raw',
		) );

	$wp_customize->add_control(
			new WP_Customize_Image_Control(
				$wp_customize,
				'logo',
				array(
					'label'    => __( 'Logo (Menu & Footer)', 'devfly' ),
					'section'  => 'title_tagline',
					'description'  => 'Image resolution - 100x36px ',
					'settings' => 'logo',
					'context'  => 'themedavfly1_custom_image',
					/*'priority' => 11,*/
				)
			)
		);
    
    /*Header slider */
    
       $wp_customize->add_panel( 'themedavfly1_panel' ,
		array(
			'priority'        => 130,
			'title'           => esc_html__( 'Section: Devfly Options', 'devfly' ),
			'description'     => '',
		)
	);
       
   $wp_customize->add_section('themedavfly1_section_header_slide', array(
        'title'    => __('Header Slider', 'devfly'),
        'description' => 'Easily add fullscreen sliders here',
        'priority' => 05,
        'panel'       => 'themedavfly1_panel',
    ));
    
    
    $wp_customize->add_setting( 'themedavfly1_header_slide', 
           array(               
               'sanitize_callback' => 'themedavfly1_sanitize_repeatable_data_field',
				'transport' => 'refresh', // refresh or postMessage              
           ) );    
    
    $wp_customize->add_control(
			new Themedavfly1_Customize_Repeatable_Control(
				$wp_customize,
				'themedavfly1_header_slide',
				array(
					'label'     => esc_html__('Header Slider', 'devfly'),
					'description'   => 'Add upto 7 slides',
					'section'       => 'themedavfly1_section_header_slide',
					//'live_title_id' => 'user_id', // apply for unput text and textarea only
					'title_format'  => esc_html__( '[live_title]', 'devfly'), // [live_title]
					'max_item'      => 7, // Maximum item can add
                    'limited_msg' 	=> wp_kses_post( 'Contact us through our Support Forum if you need more.', 'devfly' ),
                    'fields'    => array(
                        
                        
						'user_id' => array(
							'title' => esc_html__('User media', 'devfly'),
							'type'  =>'media',
							'default' => array(
									'url' => get_template_directory_uri().'/img/01.jpg',
									'id' => ''
								)
						),
                           'name' => array(
                            'title' => esc_html__('Subheading', 'devfly'),
                            'type'  =>'text',
                            'default'  => wp_kses_post('Devfly presents', 'devfly'),
                        ),
                        
                         'title' => array(
                            'title' => esc_html__('Heading', 'devfly'),
                            'type'  =>'text',
                            'default'           => wp_kses_post('WELCOME TO THE NEW WORLD', 'devfly'),
                        ),
                         'link_title' => array(
                            'title' => esc_html__('Button Text', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('TAKE A LOOK', 'devfly'),
                           
                        ),
                        'link' => array(
                            'title' => esc_html__('Button URL', 'devfly'),
                            'type'  =>'text',
                            'default'  => wp_kses_post('', 'devfly'),
                        ),    
					),

				)
			)
		);
    
    /*About us section*/
       
    
   $wp_customize->add_section('themedavfly1_about_section', array(
        'title'    => __('About Section', 'devfly'),
        'priority' => 10,
        'panel'    => 'themedavfly1_panel',
    ));
    
   $wp_customize->add_setting( 'themedavfly1_about_theme_check', 
           array( 
               'default' => 0,
               /*'transport' => 'postMessage',*/
               'sanitize_callback' => 'devfly_main_sanitize_checkbox',
           ) );
    
	$wp_customize->add_control( 'themedavfly1_about_theme_check', array(
			'type'										=> 'checkbox',
			'label' 									=> __( 'Enable/Disable this section', 'devfly' ),
			'section'  								=> 'themedavfly1_about_section',
			'priority' 								=> 1,
	) );	
    
    
    
     $wp_customize->add_setting( 'themedavfly1_about_heading', 
           array( 
               'default' => 'ABOUT US' ,
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control( 'themedavfly1_about_heading', 
           array(
			'type' => 'text',
			'section' => 'themedavfly1_about_section', // Required, core or custom.
			'label' => __( "Section Heading", 'devfly' ),
			
		) );
    
     $wp_customize->add_setting( 'themedavfly1_about_description', 
           array( 
               'default' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat. Nunc porta pellentesque est, non laoreet mi. Mauris eu tortor ut nulla bibendum gravida' ,
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control( 'themedavfly1_about_description', 
           array(
			'type' => 'textarea',
			'section' => 'themedavfly1_about_section', // Required, core or custom.
			'label' => __( "Section Description", 'devfly' ),
			
		) );
    
    $wp_customize->add_setting( 'themedavfly1_about_partition', 
           array(               
               'sanitize_callback' => 'themedavfly1_sanitize_repeatable_data_field',
				'transport' => 'refresh', // refresh or postMessage
                
           ) );    
    
    $wp_customize->add_control(
			new Themedavfly1_Customize_Repeatable_Control(
				$wp_customize,
				'themedavfly1_about_partition',
				array(
					'label'     => esc_html__('Tabbed Sections', 'devfly'),
					'description'   => 'Add upto 10 tabs',
					'section'       => 'themedavfly1_about_section',
					//'live_title_id' => 'user_id', // apply for unput text and textarea only
					'title_format'  => esc_html__( '[live_title]', 'devfly'), // [live_title]
					'max_item'      => 10, // Maximum item can add
                    'limited_msg' 	=> wp_kses_post( 'Contact us through our Support Forum if you need more.', 'devfly' ),
                    'fields'    => array(
                        
                        
                         
                        'mainhead' => array(
                            'title' => esc_html__('Main Heading', 'devfly'),
                            'type'  =>'text',
                             'default' => wp_kses_post('ABOUT', 'devfly'),
                        ),
                        
						'user_id' => array(
							'title' => esc_html__('Add/change background', 'devfly'),
							'type'  =>'media',
							'default' => array(
									'url' => get_template_directory_uri().'/img/d-1.jpg',
									'id' => ''
								)
						),
   
                        'title' => array(
                            'title' => esc_html__('Title', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('Where does it come from', 'devfly'),
                        ),
                        
                         'description' => array(
                            'title' => esc_html__('Description', 'devfly'),
                            'type'  =>'textarea',
                            'default' => wp_kses_post('Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered.', 'devfly'),
                        ),
					),

				)
			)
		);
 
    
    /*Our services*/
    
    $wp_customize->add_section('themedavfly1_application', array(
        'title'    => __('Our Services', 'devfly'),
        'priority' => 15,
        'panel'       => 'themedavfly1_panel',
    ));
    
    
    $wp_customize->add_setting( 'themedavfly1_service_check', 
           array( 
               'default' => 0,
               /*'transport' => 'postMessage',*/
               'sanitize_callback' => 'devfly_main_sanitize_checkbox',
           ) );
    
	$wp_customize->add_control( 'themedavfly1_service_check', array(
			'type'										=> 'checkbox',
			'label' 									=> __( 'Enable/Disable this section', 'devfly' ),
			'section'  								=> 'themedavfly1_application',
			'priority' 								=> 1,
	) );	
    
    
  $wp_customize->add_setting( 'themedavfly1_about_platform', 
           array(               
               'sanitize_callback' => 'themedavfly1_sanitize_repeatable_data_field',
				'transport' => 'refresh', // refresh or postMessage
                
           ) );    
    
    $wp_customize->add_control(
			new Themedavfly1_Customize_Repeatable_Control(
				$wp_customize,
				'themedavfly1_about_platform',
				array(
					'label'     => esc_html__('Create Blocks', 'devfly'),
					'description'   => 'Add upto 9 blocks',
					'section'       => 'themedavfly1_application',
					//'live_title_id' => 'user_id', // apply for unput text and textarea only
					'title_format'  => esc_html__( '[live_title]', 'devfly'), // [live_title]
					'max_item'      => 9, // Maximum item can add
                    'limited_msg' 	=> wp_kses_post( 'Contact us through our Support Forum if you need more.', 'devfly' ),
                    'fields'    => array(
						'user_id' => array(
							'title' => esc_html__('Add background image', 'devfly'),
							'type'  =>'media',
							'default' => array(
									'url' => get_template_directory_uri().'/img/feature-icon.png',
									'id' => ''
								)
						),
                        
                      
                        'title' => array(
                            'title' => esc_html__('Title', 'devfly'),
                            'type'  =>'text',
                             'default' => wp_kses_post('Technology', 'devfly'),
                        ),
                        
                         'description' => array(
                            'title' => esc_html__('Description', 'devfly'),
                            'type'  =>'textarea',
                             'default' => wp_kses_post('Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock,', 'devfly'),
                        ),
                        
                          'link' => array(
                            'title' => esc_html__('Button Link', 'devfly'),
                            'type'  =>'text',
                            'desc'  => '',
                        ),
                        
                         'linktitle' => array(
                            'title' => esc_html__('Button Text', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('Learn more', 'devfly'),
                           
                        ),
					),

				)
			)
		);
    /*Portfolio Gallery*/
    
      $wp_customize->add_section('themedavfly1_portfolio_section', array(
        'title'    => __('Portfolio Gallery', 'devfly'),
        'priority' => 17,
        'panel'       => 'themedavfly1_panel',
    ));
    
     $wp_customize->add_setting( 'themedavfly1_Portfolio_check', 
           array( 
               'default' => 0,
               /*'transport' => 'postMessage',*/
               'sanitize_callback' => 'devfly_main_sanitize_checkbox',
           ) );
    
	$wp_customize->add_control( 'themedavfly1_Portfolio_check', array(
			'type'										=> 'checkbox',
			'label' 									=> __( 'Enable/Disable this section', 'devfly' ),
			'section'  								=> 'themedavfly1_portfolio_section',
			'priority' 								=> 1,
	) );	
    
    
    
     $wp_customize->add_setting( 'themedavfly1_portfolio_heading', 
           array( 
               'default' => 'OUR PORTFOLIO' ,
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control( 'themedavfly1_portfolio_heading', 
           array(
			'type' => 'text',
			'section' => 'themedavfly1_portfolio_section', // Required, core or custom.
			'label' => __( "Section Heading", 'devfly' ),
			
		) );
    
    
    $wp_customize->add_setting( 'themedavfly1_portfolio', 
           array(               
               'sanitize_callback' => 'themedavfly1_sanitize_repeatable_data_field',
				'transport' => 'refresh', // refresh or postMessage
                
           ) );    
    
    $wp_customize->add_control(
			new Themedavfly1_Customize_Repeatable_Control(
				$wp_customize,
				'themedavfly1_portfolio',
				array(
					'label'     => esc_html__('Create Gallery images', 'devfly'),
					'description'   => 'Add upto 10 lightbox images',
					'section'       => 'themedavfly1_portfolio_section',
					//'live_title_id' => 'user_id', // apply for unput text and textarea only
					'title_format'  => esc_html__( '[live_title]', 'devfly'), // [live_title]
					'max_item'      => 10, // Maximum item can add
                    'limited_msg' 	=> wp_kses_post( 'Contact us through our Support Forum if you need more.', 'devfly' ),
                    'fields'    => array(
						'user_id' => array(
							'title' => esc_html__('User media', 'devfly'),
							'type'  =>'media',
							'default' => array(
									'url' => get_template_directory_uri().'/img/d-2.jpg',
									'id' => ''
								),
						),
                     
                        
                        'title' => array(
                            'title' => esc_html__('Title', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('Project Gold', 'devfly'),
                        ),
                        
                         'description' => array(
                            'title' => esc_html__('Description', 'devfly'),
                            'type'  =>'textarea',
                            'default' => wp_kses_post('Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it o ver 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum.', 'devfly'),
                        ),

					),

				)
			)
		);
    

    
    /*Our Team Section */
    
     $wp_customize->add_section('themedavfly1_our_team_section', array(
        'title'    => __('Our Team', 'devfly'),
        'priority' => 20,
        'panel'    => 'themedavfly1_panel',
    ));
    
    
     $wp_customize->add_setting( 'themedavfly1_our_team_check', 
           array( 
               'default' => 0,
               /*'transport' => 'postMessage',*/
               'sanitize_callback' => 'devfly_main_sanitize_checkbox',
           ) );
    
	$wp_customize->add_control( 'themedavfly1_our_team_check', array(
			'type'										=> 'checkbox',
			'label' 									=> __( 'Enable/Disable this section', 'devfly' ),
			'section'  								=> 'themedavfly1_our_team_section',
			'priority' 								=> 1,
	) );	
    
    
    
     $wp_customize->add_setting( 'themedavfly1_our_team_title', 
           array( 
               'default' => 'Our Team' ,
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control( 'themedavfly1_our_team_title', 
           array(
			'type' => 'text',
			'section' => 'themedavfly1_our_team_section', // Required, core or custom.
			'label' => __( "Section Heading", 'devfly' ),
			
		) );
    
    
     
    $wp_customize->add_setting( 'themedavfly1_team_heading', 
           array( 
               'default' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat.',
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control( 'themedavfly1_team_heading', 
           array(
			'type' => 'textarea',
			'section' => 'themedavfly1_our_team_section', // Required, core or custom.
			'label' => __( "Section Description", 'devfly' ),
			
		) );
    
    
    $wp_customize->add_setting( 'themedavfly1_team_members', 
           array(               
               'sanitize_callback' => 'themedavfly1_sanitize_repeatable_data_field',
				'transport' => 'refresh', // refresh or postMessage
                
           ) );    
    
    $wp_customize->add_control(
			new Themedavfly1_Customize_Repeatable_Control(
				$wp_customize,
				'themedavfly1_team_members',
				array(
					'label'     => esc_html__('Team Members', 'devfly'),
					'description'   => 'Add upto 9 team members',
					'section'       => 'themedavfly1_our_team_section',
					//'live_title_id' => 'user_id', // apply for unput text and textarea only
					'title_format'  => esc_html__( '[live_title]', 'devfly'), // [live_title]
					'max_item'      => 9, // Maximum item can add
                    'limited_msg' 	=> wp_kses_post( 'Contact us through our Support Forum if you need more.', 'devfly' ),
                    'fields'    => array(
						'user_id' => array(
							'title' => esc_html__('Add Author image - 300x300px', 'devfly'),
							'type'  =>'media',
							'default' => array(
									'url' => get_template_directory_uri().'/img/team/01.jpg',
									'id' => ''
								),
						),

                        
                        'name' => array(
                            'title' => esc_html__('Name', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('Mosess Gwapa', 'devfly'),
                        ),
                        
                        'designation' => array(
                            'title' => esc_html__('Designation', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('CEO / Founder', 'devfly'),
                        ),
                        
                         'description' => array(
                            'title' => esc_html__('Description', 'devfly'),
                            'type'  =>'textarea',
                            'default' => wp_kses_post('Do not seek to change what has come before. Seek to create that which has not.', 'devfly'),
                        ),
                            'facebook_title' => array(
                            'title' => esc_html__('Facebook', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('facebook', 'devfly'),
                        ),
                       
                          'facebook_link' => array(
                            'title' => esc_html__('Facebook Link', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('https://www.facebook.com/', 'devfly'),
                        ),
                        
                           'twitter_title' => array(
                            'title' => esc_html__('Twitter', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('twitter', 'devfly'),
                        ),
                       
                          'twitter_link' => array(
                            'title' => esc_html__('Twitter Link', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('https://twitter.com/login', 'devfly'),
                        ),
                        
                         'instagram_title' => array(
                            'title' => esc_html__('Instagram', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('instagram', 'devfly'),
                        ),
                       
                          'instagram_link' => array(
                            'title' => esc_html__('Instagram Link', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('https://www.instagram.com', 'devfly'),
                        ),
                        
					),

				)
			)
		);
    

    /*Choose your Plan */
    
     $wp_customize->add_section('themedavfly1_choose_plan_section', array(
        'title'    => __('Choose your Plan', 'devfly'),
        'priority' => 20,
        'panel'    => 'themedavfly1_panel',
    ));
    
    
    
    
     $wp_customize->add_setting( 'themedavfly1_choose_plan_check', 
           array( 
               'default' => 0,
               /*'transport' => 'postMessage',*/
               'sanitize_callback' => 'devfly_main_sanitize_checkbox',
           ) );
    
	$wp_customize->add_control( 'themedavfly1_choose_plan_check', array(
			'type'										=> 'checkbox',
			'label' 									=> __( 'Enable/Disable this section', 'devfly' ),
			'section'  								=> 'themedavfly1_choose_plan_section',
			'priority' 								=> 1,
	) );	
        
     $wp_customize->add_setting( 'themedavfly1_choose_plan_title', 
           array( 
               'default' => 'CHOOSE YOUR PLAN' ,
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control( 'themedavfly1_choose_plan_title', 
           array(
			'type' => 'text',
			'section' => 'themedavfly1_choose_plan_section', // Required, core or custom.
			'label' => __( "Section Heading", 'devfly' ),
			
		) );
    
    $wp_customize->add_setting( 'themedavfly1_choose_plan_dec', 
           array( 
               'default' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat.',
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control('themedavfly1_choose_plan_dec', 
           array(
			'type' => 'textarea',
			'section' => 'themedavfly1_choose_plan_section', // Required, core or custom.
			'label' => __( "Section Description", 'devfly' ),
			
		) );
    
    
    $wp_customize->add_setting( 'themedavfly1_choose_plan', 
           array(               
               'sanitize_callback' => 'themedavfly1_sanitize_repeatable_data_field',
				'transport' => 'refresh', // refresh or postMessage
                
           ) );    
    
    $wp_customize->add_control(
			new Themedavfly1_Customize_Repeatable_Control(
				$wp_customize,
				'themedavfly1_choose_plan',
				array(
					'label'     => esc_html__('Plan Blocks', 'devfly'),
					'description'   => 'Add upto 9 blocks',
					'section'       => 'themedavfly1_choose_plan_section',
					//'live_title_id' => 'user_id', // apply for unput text and textarea only
					'title_format'  => esc_html__( '[live_title]', 'devfly'), // [live_title]
					'max_item'      => 9, // Maximum item can add
                    'limited_msg' 	=> wp_kses_post( 'Contact us through our Support Forum if you need more.', 'devfly' ),
                    'fields'    => array(
						'user_id' => array(
							'title' => esc_html__('Feature Titile', 'devfly'),
							'type'  =>'text',
							'default' => wp_kses_post('START', 'devfly'),
						),
                        
                        
                          'feature_one_title' => array(
                            'title' => esc_html__('Feature One Title', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('FEATURE ONE', 'devfly'),
                        ),
                        
                        
                        'feature_one' => array(
                            'title' => esc_html__('Feature One Description', 'devfly'),
                            'type'  =>'text',
                             'default' => wp_kses_post('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros.', 'devfly'),
                        ),
                        
                        'feature_two_title' => array(
                            'title' => esc_html__('Feature Two Title', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('FEATURE TWO', 'devfly'),
                        ),
                        
                        'feature_two' => array(
                            'title' => esc_html__('Feature Two Description', 'devfly'),
                            'type'  =>'text',
                             'default' => wp_kses_post('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros.', 'devfly'),
                        ),
                        
                        
                        'feature_three_title' => array(
                            'title' => esc_html__('Feature Three Title', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('FEATURE THREE', 'devfly'),
                        ),
                        
                         'feature_three' => array(
                            'title' => esc_html__('Feature Three Description', 'devfly'),
                            'type'  =>'text',
                             'default' => wp_kses_post('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros.', 'devfly'),
                        ),
                        
                          'feature_four_title' => array(
                            'title' => esc_html__('Feature Four Title', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('FEATURE FOUR', 'devfly'),
                        ),
                        
                         'feature_four' => array(
                            'title' => esc_html__('Feature Four Description', 'devfly'),
                            'type'  =>'text',
                             'default' => wp_kses_post('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros.', 'devfly'),
                        ),
                        
                         'feature_amt' => array(
                            'title' => esc_html__('Feature Amount', 'devfly'),
                            'type'  =>'text',
                             'default' => wp_kses_post('$100', 'devfly'),
                        ),
                        
                          'feature_month' => array(
                            'title' => esc_html__('Feature Month', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('Month', 'devfly'),
                        ),
                        
                         'feature_selection' => array(
                            'title' => esc_html__('Feature Selection', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('Choose', 'devfly'),
                        ),
                        
                          'feature_selection_url' => array(
                            'title' => esc_html__('Feature Selection Url', 'devfly'),
                            'type'  =>'text',
                            'default' => wp_kses_post('', 'devfly'),
                        ),
                        
					),

				)
			)
		);
    
    
    
    
    
    /*Testimonials*/
    
     $wp_customize->add_section('themedavfly1_client_about_us_section', array(
        'title'    => __('Testimonials', 'devfly'),
        'priority' => 23,
        'panel'    => 'themedavfly1_panel',
    ));
    
    
    $wp_customize->add_setting( 'themedavfly1_client_aboutus_check', 
           array( 
               'default' => 0,
               /*'transport' => 'postMessage',*/
               'sanitize_callback' => 'devfly_main_sanitize_checkbox',
           ) );
    
	$wp_customize->add_control( 'themedavfly1_client_aboutus_check', array(
			'type'										=> 'checkbox',
			'label' 									=> __( 'Enable/Disable this section', 'devfly' ),
			'section'  								=> 'themedavfly1_client_about_us_section',
			'priority' 								=> 1,
	) );	
    
    
    
     $wp_customize->add_setting( 'themedavfly1_client_about_title', 
           array( 
               'default' => 'Testimonials' ,
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control( 'themedavfly1_client_about_title', 
           array(
			'type' => 'text',
			'section' => 'themedavfly1_client_about_us_section', // Required, core or custom.
			'label' => __( "Section Heading", 'devfly' ),
			
		) );
    
    
    $wp_customize->add_setting( 'themedavfly1_client_about', 
           array(               
               'sanitize_callback' => 'themedavfly1_sanitize_repeatable_data_field',
				'transport' => 'refresh', // refresh or postMessage
                
           ) );    
    
    $wp_customize->add_control(
			new Themedavfly1_Customize_Repeatable_Control(
				$wp_customize,
				'themedavfly1_client_about',
				array(
					'label'     => esc_html__('Client Testimonials', 'devfly'),
					'description'   => 'Add upto 10 items',
					'section'       => 'themedavfly1_client_about_us_section',
					//'live_title_id' => 'user_id', // apply for unput text and textarea only
					'title_format'  => esc_html__( '[live_title]', 'devfly'), // [live_title]
					'max_item'      => 10, // Maximum item can add
                    'limited_msg' 	=> wp_kses_post( 'Contact us through our Support Forum if you need more.', 'devfly' ),
                    'fields'    => array(
						'user_id' => array(
							'title' => esc_html__('User media', 'devfly'),
							'type'  =>'media',
							'default' => array(
									'url' => get_template_directory_uri().'/img/t-1.jpg',
									'id' => ''
								),
						),                      
                        'name' => array(
                            'title' => esc_html__('Name', 'devfly'),
                            'type'  =>'text',
                             'default' => wp_kses_post('Steeve lehman', 'devfly'),
                        ),
                        
                         'description' => array(
                            'title' => esc_html__('Review', 'devfly'),
                            'type'  =>'textarea',
                             'default' => wp_kses_post('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat.', 'devfly'),
                        ),
					),

				)
			)
		);
    
       
    /* Subscribe CTA
		----------------------------------------------------------------------*/
		$wp_customize->add_section( 'themedavfly1_newsletter' ,
			array(
				'priority'    => 35,
				'title'       => esc_html__( 'Subscribe to Email', 'devfly' ),
				'description' => '',
				'panel'       => 'themedavfly1_panel',
			)
		);
    
       
    $wp_customize->add_setting( 'themedavfly1_newsletter_disable', 
           array( 
               'default' => 0,
               /*'transport' => 'postMessage',*/
               'sanitize_callback' => 'devfly_main_sanitize_checkbox',
           ) );
    
	$wp_customize->add_control( 'themedavfly1_newsletter_disable', array(
			'type'										=> 'checkbox',
			'label' 									=> __( 'Enable/Disable this section', 'devfly' ),
			'section'  								=> 'themedavfly1_newsletter',
			'priority' 								=> 1,
            'description' => esc_html__('Check this box to hide subscribe form.', 'devfly'),
        
	) );	
    
    
    
		

			// Mailchimp Form Title
			$wp_customize->add_setting( 'themedavfly1_newsletter_title',
				array(
					'sanitize_callback' => 'sanitize_text_field',
					'default'           => esc_html__( 'SUBSCRIBE', 'devfly' ),
                    'transport'         => 'postMessage', // refresh or postMessage
				)
			);
			$wp_customize->add_control( 'themedavfly1_newsletter_title',
				array(
					'label'       => esc_html__('Subscribe Form Title', 'devfly'),
					'section'     => 'themedavfly1_newsletter',
					'description' => ''
				)
			);

			// Mailchimp action url
			$wp_customize->add_setting( 'themedavfly1_newsletter_mailchimp',
				array(
					'sanitize_callback' => 'devfly_main_sanitize_url',
					'default'           => '',
                    'transport'         => 'postMessage', // refresh or postMessage
				)
			);
			$wp_customize->add_control( 'themedavfly1_newsletter_mailchimp',
				array(
					'label'       => esc_html__('MailChimp Action URL', 'devfly'),
					'section'     => 'themedavfly1_newsletter',
					'description' => __( 'The newsletter form use MailChimp, please follow <a target="_blank" href="http://kb.mailchimp.com/lists/signup-forms/host-your-own-signup-forms">this guide</a> to know how to get MailChimp Action URL. Example <i>//yourlist.us8.list-manage.com/subscribe/post?u=anything</i>', 'devfly' )
				)
			);
    
    
    
   /*From the blog*/ 
    
    
    $wp_customize->add_section('themedavfly1_blog_section', array(
        'title'    => __('Blog Section', 'devfly'),
        'priority' => 40,
        'panel'    => 'themedavfly1_panel',
    ));
    
     
     $wp_customize->add_setting( 'themedavfly1_blog_checkbox', 
           array( 
               'default' => 0,
               /*'transport' => 'postMessage',*/
               'sanitize_callback' => 'devfly_main_sanitize_checkbox',
           ) );
    
	$wp_customize->add_control( 'themedavfly1_blog_checkbox', array(
			'type'									=> 'checkbox',
			'label' 								=> __( 'Enable Blog section', 'devfly' ),
			'section'  								=> 'themedavfly1_blog_section',
			'priority' 								=> 1,
	) );	
    
    
    
     $wp_customize->add_setting( 'themedavfly1_blog_title', 
           array( 
               'default' => 'OUR BLOG',
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control( 'themedavfly1_blog_title', 
           array(
			'type' => 'text',
			'section' => 'themedavfly1_blog_section', // Required, core or custom.
			'label' => __( "Blog Title", 'devfly' ),
			
		) ); 
    
    
    
    $wp_customize->add_setting( 'themedavfly1_blog_desciption', 
           array( 
               'default' => 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris magna eros, dictum sed leo sit amet, finibus accumsan erat.',
               'transport' => 'postMessage',
               'sanitize_callback' => 'sanitize_text_field',
           ) );
	$wp_customize->add_control( 'themedavfly1_blog_desciption', 
           array(
			'type' => 'textarea',
			'section' => 'themedavfly1_blog_section', // Required, core or custom.
			'label' => __( "Blog Description", 'devfly' ),
			
		) );    
}
add_action( 'customize_register', 'main_multi_themedavfly1_customize_register' );



/*------------------------------------------------------------------------*/
/*  devfly Sanitize Functions.
/*------------------------------------------------------------------------*/

/**
 * Sanitize Text
 */
function devfly_main_sanitize_text( $str ) {
	return sanitize_text_field( $str );
} 
/**
 * Sanitize URL
 */
function devfly_main_sanitize_url( $url ) {
	return esc_url( $url );
}
/**
 * Sanitize URL Raw
 */
function devfly_main_sanitize_url_raw( $url ) {
	return esc_url_raw( $url );
}
function devfly_main_sanitize_checkbox( $input ) {
    if ( $input == 1 ) {
		return 1;
    } else {
		return 0;
    }
}


/**
 * Sanitize repeatable data
 *
 * @param $input
 * @param $setting object $wp_customize
 * @return bool|mixed|string|void
 */
function themedavfly1_sanitize_repeatable_data_field( $input , $setting ){
    $control = $setting->manager->get_control( $setting->id );

    $fields = $control->fields;
    $input = json_decode( $input , true );
    $data = wp_parse_args( $input, array() );

    if ( ! is_array( $data ) ) {
        return false;
    }
    if ( ! isset( $data['_items'] ) ) {
        return  false;
    }
    $data = $data['_items'];

    foreach( $data as $i => $item_data ){
        foreach( $item_data as $id => $value ){

            if ( isset( $fields[ $id ] ) ){
                switch( strtolower( $fields[ $id ]['type'] ) ) {
                    case 'text':
                        $data[ $i ][ $id ] = sanitize_text_field( $value );
                        break;
                    case 'textarea':
                    case 'editor':
                        $data[ $i ][ $id ] = wp_kses_post( $value );
                        break;
                    case 'color':
                        $data[ $i ][ $id ] = sanitize_hex_color_no_hash( $value );
                        break;
                    case 'coloralpha':
                        $data[ $i ][ $id ] = devfly_main_sanitize_color_alpha( $value );
                        break;
                    case 'checkbox':
                        $data[ $i ][ $id ] =  devfly_main_sanitize_checkbox( $value );
                        break;
                    case 'select':
                        $data[ $i ][ $id ] = '';
                        if ( is_array( $fields[ $id ]['options'] ) && ! empty( $fields[ $id ]['options'] ) ){
                            // if is multiple choices
                            if ( is_array( $value ) ) {
                                foreach ( $value as $k => $v ) {
                                    if ( isset( $fields[ $id ]['options'][ $v ] ) ) {
                                        $value [ $k ] =  $v;
                                    }
                                }
                                $data[ $i ][ $id ] = $value;
                            }else { // is single choice
                                if (  isset( $fields[ $id ]['options'][ $value ] ) ) {
                                    $data[ $i ][ $id ] = $value;
                                }
                            }
                        }

                        break;
                    case 'radio':
                        $data[ $i ][ $id ] = sanitize_text_field( $value );
                        break;
                    case 'media':
                        $value = wp_parse_args( $value,
                            array(
                                'url' => '',
                                'id'=> false
                            )
                        );
                        $value['id'] = absint( $value['id'] );
                        $data[ $i ][ $id ]['url'] = sanitize_text_field( $value['url'] );

                        if ( $url = wp_get_attachment_url( $value['id'] ) ) {
                            $data[ $i ][ $id ]['id']   = $value['id'];
                            $data[ $i ][ $id ]['url']  = $url;
                        } else {
                            $data[ $i ][ $id ]['id'] = '';
                        }

                        break;
                    default:
                        $data[ $i ][ $id ] = wp_kses_post( $value );
                }

            }else {
                $data[ $i ][ $id ] = wp_kses_post( $value );
            }

            if ( count( $data[ $i ] ) !=  count( $fields ) ) {
                foreach ( $fields as $k => $f ){
                    if ( ! isset( $data[ $i ][ $k ] ) ) {
                        $data[ $i ][ $k ] = '';
                    }
                }
            }

        }
    }

    return $data;
}


/**
 * Binds JS handlers to make Theme Customizer preview reload changes asynchronously.
 */
function main_multi_themedavfly1_customize_preview_js() {
	wp_enqueue_script( 'main_multi_themedavfly1_customizer', get_template_directory_uri() . '/js/customizer.js', array( 'customize-preview' ), '20151215', true );
}
add_action( 'customize_preview_init', 'main_multi_themedavfly1_customize_preview_js' );
