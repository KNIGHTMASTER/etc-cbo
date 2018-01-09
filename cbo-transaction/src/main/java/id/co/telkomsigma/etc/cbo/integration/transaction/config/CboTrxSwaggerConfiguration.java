package id.co.telkomsigma.etc.cbo.integration.transaction.config;

/**
 * Created on 7/27/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
/*@Configuration
@ComponentScan(basePackages = {CBOConstant.PackageScanner.Cbo.COMPONENT_CBO, CBOConstant.PackageScanner.Tmf.COMPONENT_TMF})
@EnableSwagger2
@Order(5)*/
public class CboTrxSwaggerConfiguration {

/*    @Value("${jwt.header}")
    String jwtHeader;

    @Autowired
    JwtTokenUtils tokenUtils;

    @Autowired
    SigmaUserDetailsService sigmaUserDetailsService;

    @Autowired
    SigmaBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public Docket baseCoreAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Base Core APIs")
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage(CBOConstant.PackageScanner.Tmf.COMPONENT_TMF))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    @Bean
    public Docket coreAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Core APIs")
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage(CBOConstant.PackageScanner.Cbo.COMPONENT_CBO))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    @Bean
    public Docket securityAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Security APIs")
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage(TMFConstant.Common.BASE_PACKAGES))
                .paths(PathSelectors.regex("/auth.*"))
                .build();
    }

    @Bean
    public Docket publicAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Public APIs")
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage(TMFConstant.Common.BASE_PACKAGES))
                .paths(PathSelectors.regex("/public.*"))
                .build();
    }

    private ApiInfo metaData() {
        List<VendorExtension> vendorExtensions = new ArrayList<>();
        vendorExtensions.add(new SampleVendorExtension());
        return new ApiInfo(
                "Telkomsigma REST API",
                "Telkomsigma REST API for Microservices Projects",
                "1.0",
                "Terms of service",
                new Contact("Achmad Fauzi", "https://telkomsigma.co.id", "fauzi.knightmaster.achmad@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                vendorExtensions);
    }


    private class SampleVendorExtension implements VendorExtension<String>{

        @Override
        public String getName() {
            return "sample vendor extension";
        }

        @Override
        public String getValue() {
            return "1.0.0";
        }
    }

    private ApiKey apiKey() {
        return new ApiKey("AUTHORIZATION", "api_key", "header");
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(
                null,
                null,
                null, // realm Needed for authenticate button to work
                null, // appName Needed for authenticate button to work
                generateTokenForSwagger(),// apiKeyValue
                ApiKeyVehicle.HEADER,
                jwtHeader, //apiKeyName
                null);
    }

    String generateTokenForSwagger() throws UsernameNotFoundException{
        return tokenUtils.generateToken(sigmaUserDetailsService.loadUserByUsername("admin"), new Device() {
            @Override
            public boolean isNormal() {
                return true;
            }

            @Override
            public boolean isMobile() {
                return false;
            }

            @Override
            public boolean isTablet() {
                return false;
            }

            @Override
            public DevicePlatform getDevicePlatform() {
                return null;
            }
        });
    }


    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/anyPath.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
                new SecurityReference("AUTHORIZATION", authorizationScopes));
    }*/

    /*private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/api.*")).build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        new SecurityReference("mykey", authorizationScopes);
        List<SecurityReference> result = new ArrayList<>();
        result.add(new SecurityReference("mykey", authorizationScopes));
        return result;
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration("123456", "test-app-realm", "clientapp", "apiKey");
    }*/

}
