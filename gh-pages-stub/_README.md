# Kaa documentation "framework?" under the hood
## Folder structure of Jekyll files

Name         | Info
-------------| -------------
_config.yml  | Jekyll configuration file. `title` variable is used for sidebar text and base URL required for GitHub pages
_includes/   | Include files (just like headers in `C`)
_layouts/    | Templates for pages
_data/       | Data files for Jekyll engine
_site/       | Generated site
public/      | Resources
_scripts/    | Scripts for documentation building

## Folders structure of generated documentation
Name         | Info
-------------| -------------
docs/        | Documentation
autogen-docs/| Autogenerated documentation (c client doxygen, javadocs, etc.)

## Important files
Name                       | Info
---------------------------| -------------
_data/versions.yml         | Generated list of versions
_data/permanent_config.yml | Configuration variables
_data/menu.yml             | Generated menu structure
_data/generated_config.yml | Generated configuration
_includes/test.md          | Outdated version handling
_includes/variables.md     | Liquid variables (e.g. `root_url`, `github_url`, `version`) for documentation writers
_layouts/redirected.html   | Redirection logic
public/js/search.js        | Search implementation
js/scripts.js              | Different functionality (e.g. collapsing code blocks)


## File data/permanent_config.yml
Name                          | Info
------------------------------| -------------
project_url                   | A link to project site
github_url_latest             | A link to page with the latest code
github_url                    | A link to project repository
copyright_text                | Text that will be used as copyright
copyright_url                 | A link for copyright text
sidebar_img_path              | A sidebar image
google_analytics_property_id  | It is a string like UA-000000-01. Required for google analytics. [More info](https://support.google.com/analytics/answer/1032385?hl=en).

## File _data/generated_config.yml
Name                      | Info
--------------------------| -------------
version                   | Latest version
docs_root                 | Root folder for documentation

## Simplified documetation building
* Create root folder for documentation `$DOCS_ROOT` (e.g. `mkdir test-gh-pages-current`)
* Copy content of `gh-pages-stub/` into root folder of documentation (e.g. `cp -R gh-pages-stub/* test-gh-pages-current/`)
* Copy content of `doc/` folder into `$DOCS_ROOT/docs/$VERSION` folder (e.g. `mkdir test-gh-pages-current/docs/current ; cp -R gh-pages-stub/* test-gh-pages-current/docs/current/`)
* Change directory to `$DOCS_ROOT` (e.g. `cd test-gh-pages-current`)
* Create `_data/generated_config.yml` file with propriet values of version and docs_root (e.g. `printf "%s\nversion: %s \ndocs_root: %s" "---" "current" "docs"`)
* Run `_scripts/create_global_toc.rb` to generate menu (e.g. `ruby _scripts/create_global_toc.rb`)
* Optional : Run `_scripts/generate_latest_structure.rb` to support `latets` links.
* Run `jekyll serve`
