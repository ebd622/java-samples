# Build justom Java Runtime Image
# Run it after building the modular JARs (see 07/build.sh)

/bin/rm -rf custom-image

jlink \
   --module-path "output/mlib" \
   --add-modules java.base,com.myorg.theClient,com.myorg.theFirstAPI \
   --output custom-image

echo "Custom Java Runtime Image created in 'custom-image' directory."