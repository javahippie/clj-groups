(defproject clj-groups "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :min-lein-version "2.0.0"
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :javac-options ["-target" "1.8" "-source" "1.8"]
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.jgroups/jgroups "4.0.0.Final"]])
